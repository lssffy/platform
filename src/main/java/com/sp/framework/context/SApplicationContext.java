package com.sp.framework.context;

import com.sp.framework.annotation.SAutowired;
import com.sp.framework.annotation.SController;
import com.sp.framework.annotation.SService;
import com.sp.framework.beans.SBeanFactory;
import com.sp.framework.beans.SBeanWrapper;
import com.sp.framework.beans.config.SBeanDefinition;
import com.sp.framework.beans.config.SBeanPostProcessor;
import com.sp.framework.beans.support.SBeanDefinitionReader;
import com.sp.framework.beans.support.SDefaultListableBeanFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : lssffy
 * @Description : 模板引擎  IOC AOP
 * @date : 2024/1/22 22:12
 */
public class SApplicationContext extends SDefaultListableBeanFactory implements SBeanFactory {

    private String [] configurations;

    private SBeanDefinitionReader reader;

    //单例的IOC容器
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<String,Object>();

    //通用的IOC容器
    private Map<String,SBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<String,SBeanWrapper>();

    public SApplicationContext(String... configurations){
        this.configurations = configurations;
        refresh();
    }

    @Override
    public void refresh() {
        //1.定位配置文件
        reader = new SBeanDefinitionReader(this.configurations);

        //2.加载配置文件，扫描相关的类，把它们封装成BeanDefinition
        List<SBeanDefinition> beanDefinitionList = reader.loadBeanDefinitions();

        //3.注册，把配置信息放到容器里面
        doRegisterBeanDefinition(beanDefinitionList);

        //4.把不是延时加载的类，有提前初始化
        doAutowrited();

    }

    private void doAutowrited() {
        for (Map.Entry<String,SBeanDefinition> beanDefinition: super.beanDefinitionMap.entrySet()
             ) {
            String beanName = beanDefinition.getKey();
            if(!beanDefinition.getValue().isLazyInit()) {
                getBean(beanName);
            }
        }
    }

    private void doRegisterBeanDefinition(List<SBeanDefinition> beanDefinitionList) {
        for (SBeanDefinition beanDefinition : beanDefinitionList) {
            this.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
        }

    }

    public Object getBean(Class<?> beanClass) {
        return getBean(beanClass.getSimpleName());
    }


    public Object getBean(String beanName) {
        SBeanDefinition sBeanDefinition = this.beanDefinitionMap.get(beanName);
        //1.doCreateBean  实例
       Object instance = null;
        //2.拿到wrapper之后，把保存到IOC容器中去
//        if(this.factoryBeanInstanceCache.containsKey(beanName)){
//            throw new Exception("Bean " + beanName + "is exists");
//        };
        SBeanPostProcessor sBeanPostProcessor = new SBeanPostProcessor();
        sBeanPostProcessor.postProcessBeforeInitialization(instance,beanName);
        instance = instantiateBean(beanName,sBeanDefinition);
        SBeanWrapper beanWrapper = new SBeanWrapper(instance);

        this.factoryBeanInstanceCache.put(beanName,beanWrapper);

        sBeanPostProcessor.postProcessAfterInitialization(instance,beanName);

       //3.populateBean  注入
        populateBean(beanName,new SBeanDefinition(),beanWrapper);
        return this.factoryBeanInstanceCache.get(beanName).getWrappedInstance();
    }

    private void populateBean(String beanName, SBeanDefinition sBeanDefinition, SBeanWrapper sBeanWrapper) {
        Object instance = sBeanWrapper.getWrappedInstance();

        Class<?> clazz = sBeanWrapper.getWrapperClass();

        if(clazz.isAnnotationPresent(SController.class)||clazz.isAnnotationPresent(SService.class)){
            return;
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(!field.isAnnotationPresent(SAutowired.class)){continue;}
            SAutowired autowired = field.getAnnotation(SAutowired.class);

            String autowiredName = autowired.value().trim();
            if("".equals(autowiredName)){
                autowiredName = field.getType().getName();
            }
            //强制访问
            field.setAccessible(true);

            try {
                field.set(instance,this.factoryBeanInstanceCache.get(autowiredName).getWrappedInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }


    }

    private Object instantiateBean(String beanName, SBeanDefinition sBeanDefinition) {
        //拿到要实例化对象的类名
        String className = sBeanDefinition.getBeanClassName();
        //反射实例化，得到一个对象
        Object instance = null;
        try {

            if(this.singletonObjects.containsKey(className)){
                instance = this.singletonObjects.get(className);
            }else {
                Class<?> beanClass = Class.forName(className);
                instance = beanClass.newInstance();
                this.singletonObjects.put(className, instance);
                this.singletonObjects.put(sBeanDefinition.getFactoryBeanName(), instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    public String[] getBeanDefinitionNames(){
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public int getBeanDefinitionCount(){
        return this.beanDefinitionMap.size();
    }

    public Properties getConfig(){
        return this.reader.getConfig();
    }
}

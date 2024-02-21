package com.sp.framework.beans.support;

import com.sp.framework.beans.config.SBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/24 16:28
 */
public class SBeanDefinitionReader {

    private Properties config = new Properties();
    //固定配置文件中的key，相对于xml的
    private final String SCAN_PACKAGE ="scanPackage";

    private List<String> registerBeanClasses = new ArrayList<String>();

    public SBeanDefinitionReader(String... locations) {
        //通过URL定位找到其中对应的文件，然后转换为文件流
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:",""));

        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        doScanner(config.getProperty(SCAN_PACKAGE));
    }

    private void doScanner(String property) {
        //转换为文件路径，实际上就是把。替换为/就ok了
        URL url = this.getClass().getResource("/" + property.replaceAll("\\.","/"));
        File classpath = new File(url.getFile());
        for (File file : classpath.listFiles()) {
            if(file.isDirectory()) {
                doScanner(property + "." + file.getName());
            }else{
                if(!file.getName().endsWith(".class")){continue;}
                String className = (property + "." + file.getName().replace(".class",""));
                registerBeanClasses.add(className);
            }
        }
    }

    public Properties getConfig(){
        return this.config;
    }

    //把配置文件中扫描到所有配置的信息转换为SBeanDefinition对象，以便于之后IOC操作方便
    public List<SBeanDefinition> loadBeanDefinitions(){
        List<SBeanDefinition> definitions = new ArrayList<SBeanDefinition>();
        try {
            for (String className : registerBeanClasses) {
                Class<?> beanClass = Class.forName(className);
                if(beanClass.isInterface()) {continue;}
                definitions.add(doCreateBeanDefinition(beanClass.getSimpleName(), beanClass.getName()));
                Class<?> [] interfaces = beanClass.getInterfaces();
                for (Class<?> i : interfaces){
                    definitions.add(doCreateBeanDefinition(i.getName(), beanClass.getName()));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return definitions;
    }

    //把每一个配置信息解析成beanDefinition
    private SBeanDefinition doCreateBeanDefinition(String factoryBeanName,String className){
        SBeanDefinition sBeanDefinition = new SBeanDefinition();
        sBeanDefinition.setBeanClassName(className);
        sBeanDefinition.setFactoryBeanName(factoryBeanName);
        return sBeanDefinition;
    }
}

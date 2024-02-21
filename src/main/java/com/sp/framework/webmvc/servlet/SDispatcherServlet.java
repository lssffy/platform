package com.sp.framework.webmvc.servlet;

import com.sp.framework.annotation.SController;
import com.sp.framework.annotation.SRequestMapping;
import com.sp.framework.context.SApplicationContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/29 23:47
 */
@Slf4j
public class SDispatcherServlet extends HttpServlet {

    private final String CONTEXT_CONFIG_LOCATION = "contextConfigLocation";

    private SApplicationContext sApplicationContext;

    private List<SViewResolver> viewResolvers = new ArrayList<SViewResolver>();

    private List<SHandlerMapping> handlerMappings = new ArrayList<SHandlerMapping>();

    private Map<SHandlerMapping,SHandlerAdapter> handlerAdapters = new ConcurrentHashMap<SHandlerMapping,SHandlerAdapter>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("500 Exception,Details:\r\n" + Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]","").replaceAll(",\\s","\r\n"));
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //通过从request中拿到url，去匹配一个handlerMapping
        SHandlerMapping handler = getHandler(req);

        if(handler == null) {
            return;
        }
        //准备调用前的参数
        SHandlerAdapter adapter = getHandlerAdapter(handler);

        //真正的调用方法,返回ModelAndView存储
        SModelAndView mv = adapter.handler(req,resp,handler);

        //
        processDispatchResult(req,resp,mv);

    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, SModelAndView mv) {
        //把modelAndView编程一个HTML、OutputStream、json
        if(null==mv){return;}
    }

    private SHandlerAdapter getHandlerAdapter(SHandlerMapping handlerMapping) {
        return null;
    }

    private SHandlerMapping getHandler(HttpServletRequest req) throws Exception{
        if(this.handlerMappings.isEmpty()) return null;

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath,"").replaceAll("/+","/");
        for (SHandlerMapping sHandlerMapping : this.handlerMappings) {
            try{
                Matcher matcher = sHandlerMapping.getPattern().matcher(url);
                if(!matcher.find()){continue;}
                return sHandlerMapping;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、初始化IOC工厂 applicationContext
        sApplicationContext = new SApplicationContext(config.getInitParameter(CONTEXT_CONFIG_LOCATION));
        //2、初始化Springmvc九大组件
        initStrategies(sApplicationContext);
    }

    private void initStrategies(SApplicationContext context) {
        //多文件上传的组件
        initMultipartResolver(context);
        //初始化本地语言环境
        initLocaleResolver(context);
        //初始化模板处理器
        initThemeResolver(context);

        //handlerMapping  必须实现
        initHandlerMappings(context);
        //初始化参数适配器   必须实现
        initHandlerAdapters(context);

        //初始化异常拦截器
        initHandlerExceptionResolvers(context);
        //初始化视图预处理器
        initRequestToViewNameTranslator(context);

        //初始化视图转换器   必须实现
        initViewResolvers(context);

        //初始化参数缓存器
        initFlashMapManager(context);
    }

    private void initFlashMapManager(SApplicationContext context) {
    }

    private void initViewResolvers(SApplicationContext context) {
        //拿到模版的存放目录
        String templateRoot = context.getConfig().getProperty("templateRoot");
        String templatePath =  this.getClass().getClassLoader().getResource(templateRoot).getFile();
        File file = new File(templatePath);
        String [] templates = file.list();
        for (String template : templates) {
             this.viewResolvers.add(new SViewResolver(templateRoot));
        }

    }

    private void initRequestToViewNameTranslator(SApplicationContext context) {
    }

    private void initHandlerExceptionResolvers(SApplicationContext context) {
    }

    private void initHandlerAdapters(SApplicationContext context) {
        //
        for (SHandlerMapping sHandlerMapping: this.handlerMappings) {
            this.handlerAdapters.put(sHandlerMapping,new SHandlerAdapter());
        }
    }

    private void initHandlerMappings(SApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object controller = context.getBean(beanName);
            Class<?> clazz = controller.getClass();
            if(!clazz.isAnnotationPresent(SController.class)){
                continue;
            }
            String baseUrl = "";
            if(clazz.isAnnotationPresent(SRequestMapping.class)){
                SRequestMapping requestMapping = clazz.getAnnotation(SRequestMapping.class);
                baseUrl = requestMapping.value();
            }
            Method[] methods = clazz.getMethods();
            for(Method method : methods){
                if(!method.isAnnotationPresent(SRequestMapping.class)){continue;}
                SRequestMapping requestMapping = method.getAnnotation(SRequestMapping.class);
                String url = ("/" + baseUrl + "/" + requestMapping.value().replaceAll("\\*",".*")).replaceAll("/+","/");
                Pattern pattern = Pattern.compile(url);
                this.handlerMappings.add(new SHandlerMapping(pattern,controller,method));
                log.info("Mapped " + pattern + "," + method);
            }
        }



    }

    private void initThemeResolver(SApplicationContext context) {
    }

    private void initLocaleResolver(SApplicationContext context) {
    }

    private void initMultipartResolver(SApplicationContext context) {
    }
}

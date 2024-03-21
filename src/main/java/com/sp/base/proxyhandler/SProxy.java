package com.sp.base.proxyhandler;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 14:42
 */
public class SProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(SClassLoader classLoader,Class<?> [] interfaces,SInvocationHandler h){
        try {
            //动态生成源代码。java文件
            String src = generateSrc(interfaces);
            //Java文件输出磁盘
            String filePath = SProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
            //把生成的。java文件编译成。class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();
            //把编译生成的。class文件加载到jvm中
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(SInvocationHandler.class);
            f.delete();
            //返回字节码重组以后的新的代理对象
            return c.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb= new StringBuffer();
        sb.append("package com.sp.base.proxyhandler;" +ln);
        sb.append("import com.sp.demo.proxy.OneDay;" + ln);
        sb.append("import java.lang.reflect.*;" +ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName()+ "{"+ln);
        sb.append("SInvocationHandler h;"+ ln);
        sb.append("public $Proxy0(SInvocationHandler h) { "+ln);
        sb.append("this.h = h;");
        sb.append("}"+ ln);
        for(Method m : interfaces[0].getMethods()){
            Class<?>[] params= m.getParameterTypes();
            StringBuffer paramNames=new StringBuffer();
            StringBuffer paramValues=new StringBuffer();
            StringBuffer paramClasses= new StringBuffer();
            for(int i= 0;i < params.length; i++){
                Class clazz=params[i];
                String type=clazz.getName();
                String paramName= toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + "" + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if(i > 0&& i< params.length-1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }
            sb.append("public " +m.getReturnType().getName() + " " + m.getName() +"(" +
                    paramNames.toString() + "){"+ ln);
            sb.append("try{"+ ln);
            sb.append("Method m="+interfaces[0].getName()+".class.getMethod(\""
                    +m.getName()+ "\",new Class[]{"+paramClasses.toString() + "});" +ln);
            sb.append((hasReturnValue(m.getReturnType()) ?"return " : "") +
                    getCaseCode("this.h.invoke(this,m,new Object[]{"+paramValues+"})",m.getReturnType())+";"+ln);
            sb.append("}catch(Error _ex){ }");
            sb.append("catch(Throwable e){"+ ln);
            sb.append("throw new UndeclaredThrowableException(e);" +ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");
        }
        sb.append("}"+ ln);
        return sb.toString();
    }

    private static Map<Class,Class> mappings = new HashMap<Class,Class>();
    static {
        mappings.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnType) {
        if(mappings.containsKey(returnType)){
            return "return 0;";
        }else if(returnType ==void.class){
            return "";
        }else{
            return"return null;";
        }
    }

    private static String getCaseCode(String s, Class<?> returnType) {
        if(mappings.containsKey(returnType)){
            return "(("+mappings.get(returnType).getName() + ")"+ s+ ")."+
                    returnType.getSimpleName() +"Value()";
        }
        return s;
    }

    private static boolean hasReturnValue(Class<?> returnType) {
        return returnType != void.class;
    }

    private static String toLowerFirstCase(String simpleName) {
        char [] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}

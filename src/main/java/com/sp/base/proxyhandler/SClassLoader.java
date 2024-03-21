package com.sp.base.proxyhandler;

import java.io.*;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 14:44
 */
public class SClassLoader extends ClassLoader{

    private File classPathFile;

    public SClassLoader(){
        String classPath = SClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = SClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            File classFile = new File(classPathFile,name.replace("\\", "/") + ".class");
            if(classFile.exists()) {
                FileInputStream fis = null;
                ByteArrayOutputStream out = null;

                try {
                    fis = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte [] buff = new byte[1024];
                    int len;
                    while((len=fis.read(buff))!=-1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(null!=fis){
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(null!=out){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}

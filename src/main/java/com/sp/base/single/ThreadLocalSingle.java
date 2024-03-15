package com.sp.base.single;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/13 17:47
 */
public class ThreadLocalSingle {
    private ThreadLocalSingle(){}
    private static final ThreadLocal<ThreadLocalSingle> localSingleThreadLocal =
            new ThreadLocal<ThreadLocalSingle>(){
        @Override
        protected ThreadLocalSingle initialValue() {
            return new ThreadLocalSingle();
        }
    };

    public static ThreadLocalSingle getInstance(){
        return localSingleThreadLocal.get();
    }
}

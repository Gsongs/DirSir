package com.bawei.library_framework.logmanager;

import android.util.Log;

public
/**
 *作者：王先生
 *时间：2021/12/10 10:12
 *用途：日志拦截封装
 */
class LogManager {

    //类名
    public static String className;
    //方法名
    public static String methodName;
    //行数
    public static int lineNumber;

    public volatile static LogManager manager=null;
    public static LogManager getManager() {
        if (manager == null){
            synchronized (LogManager.class){
                if (manager == null){
                    manager = new LogManager();
                }
            }
        }
        return manager;
    }

    private static String createLog(String logg){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("=======");
        stringBuffer.append(methodName);
        stringBuffer.append("(").append(className).append(":").append(lineNumber).append(")-------------------:");
        stringBuffer.append(logg);
        return stringBuffer.toString();
    }

    public static void getMethodNames(StackTraceElement[] elements) {
        className = elements[1].getFileName();    //类名
        methodName = elements[1].getMethodName();   // 方法名
        lineNumber = elements[1].getLineNumber();  //行数
    }
    //    log.e
    public  void e(String message){
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className,createLog(message));
    }
    public  void i(String message){
        getMethodNames(new Throwable().getStackTrace());
        Log.i(className,createLog(message));
    }
    public  void d(String message){
        getMethodNames(new Throwable().getStackTrace());
        Log.d(className,createLog(message));
    }

    public  void v(String message){
        getMethodNames(new Throwable().getStackTrace());
        Log.v(className,createLog(message));
    }

    public  void w(String message){
        getMethodNames(new Throwable().getStackTrace());
        Log.w(className,createLog(message));
    }
}

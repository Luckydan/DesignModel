package com.luckydan.singleton.safe;

import com.luckydan.singleton.unsafe.UnsafeSingleton;

/**
 * @Title: 防止单例模式被反射破环
 * @Description:
 * @Author: GL
 * @Date: 2020/4/18 23:12
 * @Version 1.0.0
 */
public enum AntiReflectSingleton {
    INSTANCE;

    /**
     * 私有化构造方法
     */

    private AntiReflectSingleton(){

    }

    /**
     * 通过对外的方法获取单例对象
     * @return
     */
    public static  AntiReflectSingleton getInstance(){
        return INSTANCE;
    }

    public void invokeSingleTestInfo(){
        System.out.println("调用非线程安全的单例对象方法");
    }
}

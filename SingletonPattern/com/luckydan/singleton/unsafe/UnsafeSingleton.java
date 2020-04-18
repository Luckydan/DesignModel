package com.luckydan.singleton.unsafe;

/**
 * @Title: 非线程安全的单例模式
 * @Description:
 * @Author: GL
 * @Date: 2020/4/18 22:54
 * @Version 1.0.0
 */
public class UnsafeSingleton {
    private static UnsafeSingleton  unsafeSingleton = null;
    /**
     * 私有化构造方法
     */

    private UnsafeSingleton(){

    }

    /**
     * 通过对外的方法获取单例对象
     * @return
     */
    public static  UnsafeSingleton getInstance(){
        // 当多线程的环境下，此处存在线程不安全的隐患，生成多个对象，从而引起数据不一致等问题
        if(unsafeSingleton == null){
            unsafeSingleton = new UnsafeSingleton();
        }
        return  unsafeSingleton;
    }

    public void invokeSingleTestInfo(){
        System.out.println("调用非线程安全的单例对象方法");
    }
}

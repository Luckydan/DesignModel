package com.luckydan.singleton.safe;

import com.luckydan.singleton.SingletonTest;

/**
 * @Title: 线程安全的单例模式,指令重排的问题，也会破坏单例，
 * @Description:另外如果懒汉单例需要实现线程模式，需要惊醒双重检测保证单例（略）
 * @Author: GL
 * @Date: 2020/4/18 23:03
 * @Version 1.0.0
 */
public class SafeSingleton {
    private static volatile SafeSingleton safeSingleton = new SafeSingleton();

    private SafeSingleton(){
    }

    public synchronized  static SafeSingleton getInstance(){
        return safeSingleton;
    }

    public void invokeSafeSingleInfo(){
        System.out.println("调用线程安全的单例对象方法");
    }
}

package com.luckydan.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Title: 代理类直接实现InvocationHandler
 * @Description:
 * @Author: GL
 * @Date: 2020/4/15 23:02
 * @Version 1.0.0
 */
public class FilmDynamicProxyTwo implements InvocationHandler {

    private Object bean;

    public FilmDynamicProxyTwo(Object bean){
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("获取代理对象之前");
        Object target = method.invoke(this.bean, args);
        System.out.println("获取代理对象之后");
        return target;
    }
    // JDK自带的生成代理类的静态方法，第一个参数是类加载器 第二个参数是被代理类的接口 第三个参数是被代理的对象
    // 这个方法内部的大致原理就是动态的加载这个类，然后放到内存中，所以不是编译时期生成的，是运行的时候生成的
    public static Object proxy(Class interfaceClazz, Object proxy){
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(),new Class[]{interfaceClazz},new FilmDynamicProxyTwo(proxy));
    }

}

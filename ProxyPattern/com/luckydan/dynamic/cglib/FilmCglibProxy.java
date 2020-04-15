package com.luckydan.dynamic.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Title:
 * @Description:
 * @Author: GL
 * @Date: 2020/4/15 23:48
 * @Version 1.0.0
 */
public class FilmCglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invoke");
        Object object = methodProxy.invokeSuper(o,objects);
        System.out.println("after invoke");
        return object;
    }
}

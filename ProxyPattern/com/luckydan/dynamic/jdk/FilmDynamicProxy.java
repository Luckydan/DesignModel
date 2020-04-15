package com.luckydan.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Title:
 * @Description:
 * @Author: GL
 * @Date: 2020/4/13 22:54
 * @Version 1.0.0
 */
public class FilmDynamicProxy {
    private Object film;

    public FilmDynamicProxy(Object filmBean){
        this.film = filmBean;
    }

    public Object createFilmProxy(){
        Object proxyInstance = Proxy.newProxyInstance(film.getClass().getClassLoader(), film.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("交由文化部门进行审批审核");
                return method.invoke(film,args);
            }
        });
        return proxyInstance;
    }
}

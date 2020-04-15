package com.luckydan.dynamic.cglib;

import com.luckydan.dynamic.jdk.Film;
import com.luckydan.dynamic.jdk.SportsFilm;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Title: 测试Cglib的动态代理类
 * @Description:
 * @Author: GL
 * @Date: 2020/4/15 23:51
 * @Version 1.0.0
 */
public class FilmCglibProxyTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\CloneCode\\DesignModel\\ProxyPattern\\out\\production\\DesignModel");

        //创建Enhancer对象，类似于JDK动态代理的Proxy类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SportsFilm.class);

        //设置回调函数
        enhancer.setCallback(new FilmCglibProxy());

        //获取代理对象的代理类
        Film film = (Film)enhancer.create();
        film.descripe();

    }
}

package com.luckydan;

import com.luckydan.dynamic.jdk.SportsFilm;

/**
 * @Title: 静态代理，代理类通过实现代理对象的接口，来实现代理操作
 * @Description:
 * @Author: GL
 * @Date: 2020/4/15 23:39
 * @Version 1.0.0
 */
public class FilmStaticProxyTest {
    public static void main(String[] args) {
        FilmStaticProxy filmStaticProxy = new FilmStaticProxy(new SportsFilm());
        filmStaticProxy.descripe();
    }
}

package com.luckydan;

import com.luckydan.dynamic.jdk.Film;

/**
 * @Title:
 * @Description:
 * @Author: GL
 * @Date: 2020/4/15 23:36
 * @Version 1.0.0
 */
public class FilmStaticProxy implements Film {

    private Film film;

    public FilmStaticProxy(Film film){
        this.film =film;
    }
    @Override
    public void descripe() {
        System.out.println("调用该方法之前");
        film.descripe();
        System.out.println("调用该方法之前");
    }

    @Override
    public void show() {
        System.out.println("调用该方法之前");
        film.show();
        System.out.println("调用该方法之前");
    }
}

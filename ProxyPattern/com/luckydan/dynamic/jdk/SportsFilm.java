package com.luckydan.dynamic.jdk;

/**
 * @Title:
 * @Description:
 * @Author: GL
 * @Date: 2020/4/13 22:48
 * @Version 1.0.0
 */
public class SportsFilm implements Film {
    @Override
    public void descripe() {
        System.out.println("该电影描述了C罗一生传奇的足球生涯");
    }

    @Override
    public void show() {
        System.out.println("上映时间：2020-4-12");
    }
}

package com.luckydan.dynamic.jdk;

/**
 * @Title:
 * @Description:
 * @Author: GL
 * @Date: 2020/4/13 23:19
 * @Version 1.0.0
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        // 第一种动态代理调用测试
        SportsFilm sportsFilm = new SportsFilm();
        Object filmProxy =new FilmDynamicProxy(sportsFilm).createFilmProxy();
        ((Film) filmProxy).descripe();

        // 第二种动态代理调用测试
        Film filmProxyTwo =(Film)FilmDynamicProxyTwo.proxy(Film.class, new SportsFilm());
        filmProxyTwo.descripe();


    }
}

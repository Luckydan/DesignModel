package com.luckydan.singleton.safe;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Title: 防止单例对象被反序列化破坏
 * @Description:序列化是将 java 对象转换为字节流，反序列化是从字节流转换为 java 对象。
 * @Author: GL
 * @Date: 2020/4/18 23:34
 * @Version 1.0.0
 */
public class AntiSerializeSingleton implements Serializable {
    private static final AntiSerializeSingleton instance = new AntiSerializeSingleton();

    private AntiSerializeSingleton(){

    }

    public static AntiSerializeSingleton getInstance(){
        return instance;
    }

    /**
     * 在反序列化的时候，JVM 会自动调用 readResolve() 这个方法，我们可以在这个方法中替换掉从流中反序列化回来的对象。
     */
    public Object readResolve() throws ObjectStreamException {
        return instance;
    }
}

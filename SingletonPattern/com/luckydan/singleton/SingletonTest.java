package com.luckydan.singleton;

import com.luckydan.singleton.safe.AntiReflectSingleton;
import com.luckydan.singleton.safe.AntiSerializeSingleton;
import com.luckydan.singleton.safe.SafeSingleton;
import com.luckydan.singleton.unsafe.UnsafeSingleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Title:
 * @Description:
 * @Author: GL
 * @Date: 2020/4/18 22:59
 * @Version 1.0.0
 */
public class SingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1.非安全模式的单例模式
        UnsafeSingleton unsafeSingleton = UnsafeSingleton.getInstance();
        unsafeSingleton.invokeSingleTestInfo();

        // 2.通过反射会破环简单的单例模式
        Constructor constructor  = UnsafeSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        UnsafeSingleton  unsafeSingleton1= (UnsafeSingleton)constructor.newInstance();
        System.out.println(unsafeSingleton ==unsafeSingleton1);

        // 3.通过枚举模式防止反射的破环测试
        AntiReflectSingleton antiReflectSingleton = AntiReflectSingleton.getInstance();
        // 当使用枚举模式后，再使用反射获取类的构造方法，会报错java.lang.NoSuchMethodException
//        Constructor<AntiReflectSingleton> antiReflectSingletonConstructor = AntiReflectSingleton.class.getDeclaredConstructor();
//        antiReflectSingletonConstructor.setAccessible(true);
//        AntiReflectSingleton antiReflectSingleton1 = (AntiReflectSingleton)antiReflectSingletonConstructor.newInstance();
//        System.out.println(antiReflectSingleton == antiReflectSingleton1);

        // 4. 序列化也会破环单例模式
        AntiSerializeSingleton antiSerializeSingleton=AntiSerializeSingleton.getInstance();
        AntiSerializeSingleton unsafeSingleton3 = null;
        ByteArrayOutputStream bout = null;
        ObjectOutputStream out = null;
        try {
            bout = new ByteArrayOutputStream();
            out = new ObjectOutputStream(bout);
            out.writeObject(antiSerializeSingleton);

            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bin);
            unsafeSingleton3 = (AntiSerializeSingleton) in.readObject();
        } catch (Exception e) {
        } finally {
            // close bout&out
        }
        System.out.println(antiSerializeSingleton == unsafeSingleton3);


        // 4 线程安全的单例模式
        SafeSingleton safeSingleton = SafeSingleton.getInstance();
        safeSingleton.invokeSafeSingleInfo();
    }
}

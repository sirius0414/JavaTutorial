package org.siyue.javatutorial.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClassLoaderDemo {

    // 一个“只负责把给定字节码 define 成目标类”的 ClassLoader
    // 注意：我们不会在 loadClass 里走父委派，而是直接提供 define() 方法来绕过默认行为
    static class ByteArrayClassLoader extends ClassLoader {
        ByteArrayClassLoader(ClassLoader parent) {
            super(parent);
        }

        // 直接用 defineClass 定义类：同名类在不同加载器下将成为不同的 Class
        Class<?> define(String binaryName, byte[] bytecode) {
            return defineClass(binaryName, bytecode, 0, bytecode.length);
        }
    }

    public static void main(String[] args) throws Exception {
        // 读取同一份 Hello.class 字节码
        String binaryName = "org.siyue.utils.Hello";
        String resourcePath = "org/siyue/utils/Hello.class";

        byte[] allBytes = readAllBytes(resourcePath);

        // 两个不同的加载器（parent 都是 AppClassLoader，但彼此仍然是不同 namespace）
        ByteArrayClassLoader l1 = new ByteArrayClassLoader(ClassLoaderDemo.class.getClassLoader());
        ByteArrayClassLoader l2 = new ByteArrayClassLoader(ClassLoaderDemo.class.getClassLoader());

        // 用同一份字节码，在两个加载器中定义出两个“同名类”
        Class<?> c1 = l1.define(binaryName, allBytes);
        Class<?> c2 = l2.define(binaryName, allBytes);

        System.out.println("c1 == c2 ? " + (c1 == c2));
        System.out.println("c1 loader: " + c1.getClassLoader());
        System.out.println("c2 loader: " + c2.getClassLoader());
        System.out.println("c1 name:   " + c1.getName());
        System.out.println("c2 name:   " + c2.getName());

        // 分别实例化
        Object o1 = c1.getDeclaredConstructor().newInstance();
        Object o2 = c2.getDeclaredConstructor().newInstance();

        System.out.println("o1 class == o2 class ? " + (o1.getClass() == o2.getClass()));

        System.out.println("Is o1 an instance of c1? " + c1.isInstance(o1));
        System.out.println("Is o2 an instance of c2? " + c2.isInstance(o2));
        System.out.println("Is o1 an instance of c2? " + c2.isInstance(o1));
        System.out.println("Is o2 an instance of c1? " + c1.isInstance(o2));

        // 关键：尝试把 l1 的 Hello 实例，当作 l2 的 Hello 来 cast（会失败）
        try {
            Object casted = c2.cast(o1); // 等价于 (Hello-from-l2) o1
            System.out.println("casted = " + casted);
        } catch (ClassCastException e) {
            System.out.println("Expected ClassCastException:");
            e.printStackTrace(System.out);
        }
    }

    private static byte[] readAllBytes(String fileName) throws IOException {
        InputStream inputStream = ClassLoaderDemo.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IOException("Resource not found: " + fileName);
        }
        return inputStream.readAllBytes();
    }
}


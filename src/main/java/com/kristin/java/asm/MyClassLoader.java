package com.kristin.java.asm;

/**
 * @author hang li
 * @since 2018/5/8
 */
public class MyClassLoader extends ClassLoader {

    public Class<?> defineMyClass(byte[] b, int off, int len) {
        return super.defineClass(b, off, len);
    }

}

package com.kristin.source;


import java.io.Serializable;
import java.util.*;

/**
 * @author hang li
 * @since 2018/5/28
 */
public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

    /**
     * 版本序列号
     */
    private static final long serialVersionUID = 6829659535628717725L;

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空数组,当用户指定ArrayList容量为0时,返回该数组
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 一个空数组
     * 当用户没有指定数组容量时,返回该数组,数据量为0
     * 当用户第一次添加元素时,数组将会扩容,变成数组容量为10的数组,通过调用ensureCapacityInternational()实现
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 保存数据,ArrayList的容量就是elementData数组的长度
     * 想要了解transient关键字可以看帖子: http://www.cnblogs.com/lanxuezaipiao/p/3369962.html
     */
    transient Object[] elementData;

    /**
     * ArrayList实际存储的数据数量
     */
    private int size;

    /**
     * 创建一个初始容量为initialCapacity的ArrayList
     *
     * @param initialCapacity
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    /**
     * 创建一个空的ArrayList,长度为0,当第一次添加元素时,进行数组扩容
     */
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 将集合中的元素全部添加到ArrayList实例中
     *
     * @param c
     */
    public ArrayList(Collection<? extends E> c) {
        elementData = c.toArray();  //将集合转化为Object数组
        if ((size = elementData.length) != 0) {
            // c.toArray might (incorrectly) not return Object[] (see 6260652   查看Java Bug可以看帖子: http://www.cnblogs.com/Hangtutu/p/9066967.html
            if (elementData.getClass() != Object[].class) {
                elementData = Arrays.copyOf(elementData, size, Object[].class);
            }
        } else {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    public void trimToSize() {
        modCount++;
        if (size < elementData.length) {

        }
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

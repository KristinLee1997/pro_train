package com.kristin.guava.basicUtilites;

import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * @author hang li
 * @since 2018/5/22
 * 前置条件
 */
public class OptionalTest2 {
    @Test
    public void test() {
        //1.检查boolean是否为true，用来检查传递给方法的参数。
        int i = 3;
        int j = 2;
        Preconditions.checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
//        Preconditions.checkArgument(i < j, "Expected i < j, but %s > %s", i, j);

        //2.检查value是否为null，该方法直接返回value，因此可以内嵌使用checkNotNull。
        String orderDate = "20180416";
        String bookingDate = null;
        String test = Preconditions.checkNotNull(orderDate, "this argument is null", orderDate);
        System.out.println(test);
//        Preconditions.checkNotNull(bookingDate, "this argument is null", bookingDate);

        //3.用来检查对象的某些状态。
//        Preconditions.checkState(1 < 2);

        //4.检查index作为索引值对某个列表、字符串或数组是否有效。index>=0 && index<size *
        int index = 6;
        int size = 5;
//        Preconditions.checkElementIndex(index, size);

        //5.检查index作为位置值对某个列表、字符串或数组是否有效。index>=0 && index<=size *
//        Preconditions.checkPositionIndex(index, size);

        //6.检查[start, end]表示的位置范围对某个列表、字符串或数组是否有效*
        int start = 2;
        int end = 7;
        Preconditions.checkPositionIndexes(start, end, size);


        int field = 3;
        field = Preconditions.checkNotNull(field);
    }
}

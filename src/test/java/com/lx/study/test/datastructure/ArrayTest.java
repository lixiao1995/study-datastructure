package com.lx.study.test.datastructure;

import com.lx.study.datastructure.array.Array;
import org.junit.Test;

/**
 * @Description 数组测试
 * @Author lixiao
 * @Data 2020/3/20 16:35
 * @Version 1.0
 **/

public class ArrayTest {

    @Test
    public void arrayTest(){
        Array<Integer> array = new Array<Integer>();
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        System.out.println(array);
    }
}

package com.lx.study.datastructure;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description
 *      数组是一种线性的数据结构，数量固定
 *      优点：
 *          根据索引检索快，定义简单
 *      缺点：
 *          1，容量固定，大小一旦确定便不可改变
 *          2，在内存中分配需要连续的内存空间，所以对应的容量有上限
 *          3，增加、删除效率相对较低
 *          4，没有封装好的操作方法，都需要用户自己封装
 * @Author lixiao
 * @Data 2020/3/20 10:53
 * @Version 1.0
 **/

public class Array<T> {

    private Object[] arrs;

    //当前数组内数据数量
    private int size;

    //数组容量
    private int capacity;

    public Array() {
        this(10);
    }
    public Array(int capacity) {

        capacityCheck(capacity);
        arrs = new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * 添加方法
     * @param t
     * @return
     */
    public boolean add(T t){
       return add(size,t);
    }

    /**
     * 给数组中指定的索引处添加数据
     * @param index
     * @param t
     * @return
     */
    public boolean add(int index, T t){
        indexCheckForAdd(index);
        rangeCheck();
        if(index == size){
            arrs[size++] = t;
            return true;
        }

        for (int i = size; i > index; i--) {
            arrs[i] = arrs[i-1];
        }
        /*
         *  上述for循环等同于
         *          ==》
         *      if (size - index >= 0) System.arraycopy(arrs, index, arrs, index + 1, size - index);
         *
         *   System.arraycopy(A,B,C,D,E) 方法参数解析
         *      A：源数组
         *      B：从源数组的下标为B的数据开始（包含这个数据）开始拷贝
         *      C：目标数组
         *      D：将拷贝的数据从目标数组的D下标开始放入到目标数据
         *      E：从源数组上拷贝的数据个数
         */
        arrs[index] = t;
        size++;
        return true;

    }

    /**
     * 删除指定下标下的数据
     * @param index
     * @return
     */
    public T delete(int index){
        T oldValue = get(index);
        if(index == size - 1){
            arrs[index] = null;
        }else{
            for (int i = index; i < size - 1; i++) {
                arrs[i] = arrs[i+1];
            }
        }
       //if (size - 1 - index >= 0) System.arraycopy(arrs, index + 1, arrs, index, size - 1 - index);
        size--;
        return oldValue;
    }

    /**
     * 删除指定元素
     * @param t
     * @return
     */
    public boolean delete(T t){
        if(t == null){
            for (int i = 0; i < size; i++) {
                if(arrs[i] == null){
                    delete(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if(t.equals(arrs[i])){
                    delete(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否包含某个元素
     * @param t
     * @return
     */
    public boolean contain(T t){
        if(t == null){
            for (int i = 0; i < size; i++) {
                if(arrs[i] == null){
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if(t.equals(arrs[i])){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 将指定位置的元素替换
     * @param index
     * @param t
     * @return
     */
    public T set(int index, T t){
        T oldValue = get(index);
        arrs[index] = t;
        return oldValue;
    }

    /**
     *
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    public T get(int index){
        indexCheck(index);
        return (T)arrs[index];
    }

    /**
     * 获取第一个
     * @return
     */
    public T getFirst(){
        return get(0);
    }
    /**
     * 获取最后一个
     * @return
     */
    public T getLast(){
        return get(size-1);
    }

    private void rangeCheck(){
        if(size == capacity){
            throw new IllegalArgumentException("Failed to add,this array is full");
        }
    }
    private void capacityCheck(int capacity){
        if(capacity < 0 || capacity > Integer.MAX_VALUE - 8 ){
            throw new IllegalArgumentException("Illegal capacity");
        }
    }

    private void indexCheckForAdd(int index) {
        if(index < 0 || index > capacity ){
            throw new IllegalArgumentException("Falid add,this array is full");
        }
    }

    private void indexCheck(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(arrs[i]);
            if(i + 1 != size){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}

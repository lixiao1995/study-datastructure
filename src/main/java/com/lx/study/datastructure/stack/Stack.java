package com.lx.study.datastructure.stack;

import com.lx.study.datastructure.array.Array;

/**
 * @program: Data-Structure-Study
 * @description: 栈学习
 *     栈主要用途：
 *          系统调用
 *           编辑器撤回功能
 *           括号匹配算法
 * @author: lixiao
 * @create: 2020-03-21 19:33
 **/
public class Stack<T> {

    private Array<T> array = new Array<>(10);

    /**
     * 压栈
     * @param t
     * @return
     */
    public boolean push(T t){
        return array.add(array.getSize(),t);
    }

    /**
     * 获取栈内剩余元素数量
     * @return
     */
    public int getCount(){
        return array.getSize();
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return array.getSize() == 0;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        int topIndex = array.getSize() - 1;
        if(topIndex < 0){
          return null;
        }
        T t = array.get(topIndex);
        array.delete(topIndex);
        return t;
    }

    /**
     * 查看栈顶数据
     * @return
     */
    public T top(){
        return array.get(array.getSize()-1);
    }

    @Override
    public String toString() {
        return array.toString();
    }

    /**
     * 括号匹配算法
     * @param content
     * @return
     */
    public static boolean bracketMatchingAlgorithm(String content){
        char[] chars = content.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0, size = chars.length; i < size; i++) {
            char c = chars[i];
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(c == ')' && stack.pop() != '('){
                    return false;
                }else if(c == ']' && stack.pop() != '['){
                    return false;
                }else if(c == '}' && stack.pop() != '{'){
                    return false;
                }
            }
        }
        //循环完了但是栈中没有被消耗完，视为匹配失败
        return stack.isEmpty();
    }
}

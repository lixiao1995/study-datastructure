package com.lx.study.test.datastructure;

import com.lx.study.datastructure.stack.Stack;
import org.junit.Test;

/**
 * @program: study-datastructure
 * @description: 栈测试
 * @author: lixiao
 * @create: 2020-03-22 17:58
 **/
public class StackTest {

    private Stack<Integer> stack = new Stack<>();
    {
        stack.push(1);
        stack.push(3);
        stack.push(2);
    }
    @Test
    public void pushTest(){
        stack.push(4);
        System.out.println(stack);
    }
    @Test
    public void popTest(){
        System.out.println("出栈的元素是："+stack.pop());
        System.out.println("出栈后栈内情况："+stack);
    }
    @Test
    public void topTest(){
        System.out.println("栈顶的元素是："+stack.top());
    }
    @Test
    public void getCountTest(){
        System.out.println("栈里面一共有："+stack.getCount());
    }
    @Test
    public void isEmptyTest(){
        Stack<Integer> stack = new Stack<>();
        System.out.println("新建的栈是不是空的："+stack.isEmpty());
        System.out.println("原来的栈是不是空的："+this.stack.isEmpty());
    }
    @Test
    public void bracketMatchingAlgorithmTest(){
        System.out.println(Stack.bracketMatchingAlgorithm("{}[]()"));
        System.out.println(Stack.bracketMatchingAlgorithm("({[]})"));
        System.out.println(Stack.bracketMatchingAlgorithm("({[}]})"));
    }
}

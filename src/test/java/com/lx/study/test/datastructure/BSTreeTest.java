package com.lx.study.test.datastructure;

import com.lx.study.datastructure.tree.bst.BSTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: study-datastructure
 * @description: 二叉树测试
 * @author: lixiao
 * @create: 2020-05-01 18:17
 **/
public class BSTreeTest {

    private BSTree<Integer> bsTree;
    /*
       50,43,444,3,666,7,44,5,80
                50
              43   444
            3   44     666
              7   80
            5
 */
    @Before
    public void init(){
        int[] arr = {50,43,444,3,666,7,44,5,80};
        bsTree = new BSTree<>();
        for (int i : arr) {
            bsTree.add(i);
        }
    }
    @Test
    public void containsTest(){
        Assert.assertTrue(bsTree.contains(50));
        Assert.assertTrue(bsTree.contains(43));
        Assert.assertTrue(bsTree.contains(444));
        Assert.assertTrue(bsTree.contains(3));
        Assert.assertTrue(bsTree.contains(666));
        Assert.assertTrue(bsTree.contains(7));
        Assert.assertTrue(bsTree.contains(44));
        Assert.assertTrue(bsTree.contains(5));
        Assert.assertTrue(bsTree.contains(80));
        Assert.assertTrue(bsTree.contains(44));
        Assert.assertFalse(bsTree.contains(441));
        Assert.assertFalse(bsTree.contains(120));
        Assert.assertFalse(bsTree.contains(110));
    }
    @Test
    public void addTest(){
        //已包含元素添加失败
        Assert.assertFalse(bsTree.add(44));
        Assert.assertFalse(bsTree.addNR(44));
        //未包含元素添加成功
        Assert.assertTrue(bsTree.addNR(33));
    }
    @Test
    public void prevOrderTest(){
        bsTree.prevorder();
        System.out.println("------------------------");
        bsTree.inorder();
        System.out.println("------------------------");
        bsTree.postorder();
    }
    @Test
    public void pervorderNRTest(){
        System.out.println("----------非递归--------------");
        bsTree.prevorderNR();
        System.out.println("----------递归--------------");
        bsTree.prevorder();
    }
}

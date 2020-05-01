package com.lx.study.datastructure.tree.bst;

import java.util.Objects;
import java.util.Stack;


/**
 * @program: study-datastructure
 * @description: 二叉搜索树
 * @author: lixiao
 * @create: 2020-05-01 17:48
 **/
public class BSTree<E extends Comparable<E>> {

    private int size;
    private Node root;

    private class Node {
        E value;
        Node left;
        Node right;

        Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //小递归实现
    public boolean addNR(E value) {

        Objects.requireNonNull(value);
        int currentSize = size;
        if (root == null) {
            root = new Node(value);
            size++;
        } else {
            addNR(value, root);
        }
        return currentSize != size;
    }

    //纯递归实现
    public boolean add(E value) {
        Objects.requireNonNull(value);
        int currentSize = size;
        root = add(value, root);
        return currentSize != size;
    }

    private void addNR(E value, Node node) {
        if (value.compareTo(node.value) == 0) {
            return;
        }
        //判断当前值是否小于当前节点的，如果小于且当前节点的左节点不为null，则将当前值设置为当前节点的左子节点
        if (value.compareTo(node.value) < 0 && node.left == null) {
            node.left = new Node(value);
            size++;
        } else if (value.compareTo(node.value) > 0 && node.right == null) {
            node.right = new Node(value);
            size++;
        }

        if (value.compareTo(node.value) < 0) {
            addNR(value, node.left);
        } else {
            addNR(value, node.right);
        }
    }

    private Node add(E value, Node node) {
        if (node == null) {
            size++;
            return new Node(value);
        }
        //如果当前节点的值小于给定值，则将当前节点的左子节点传入当前函数递归
        //如果当前节点的值大于给定值，则将当前节点的右子节点传入当前函数递归
        if (value.compareTo(node.value) < 0)
            node.left = add(value, node.left);
        else if (value.compareTo(node.value) > 0)
            node.right = add(value, node.right);
        //如果当前节点的值等于给定值，则什么都不做直接返回
        return node;
    }

    public boolean contains(E e) {
        return contains(e, root);
    }

    private boolean contains(E e, Node node) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.value) == 0) {
            return true;
        } else if (e.compareTo(node.value) < 0) {
            return contains(e, node.left);
        } else {
            return contains(e, node.right);
        }
    }

    /**
     * 前序遍历，先访问当前节点，后访问左子节点，最后访问右子节点
     */
    public void prevorder() {
        traverse(root, OrderType.PREVORDER);
    }

    /**
     * 中序遍历，先访问左子节点，后访问当前节点，最后访问右子节点 ，结果总是从小到大（根节点除外）
     */
    public void inorder() {
        traverse(root, OrderType.INORDER);
    }

    /**
     * 后序遍历，先访问左子节点，后访问右子节点，最后访问当前节点 常用于垃圾回收
     */
    public void postorder() {
        traverse(root, OrderType.POSTORDERl);
    }

    private void traverse(Node node, OrderType orderType) {
        if (node == null) {
            return;
        }
        if (orderType.equals(OrderType.PREVORDER)) {
            System.out.println(node.value);
        }
        //处理左子节点
        traverse(node.left, orderType);
        if (orderType.equals(OrderType.INORDER)) {
            System.out.println(node.value);
        }
        //处理右子节点
        traverse(node.right, orderType);
        if (orderType.equals(OrderType.POSTORDERl)) {
            System.out.println(node.value);
        }
    }

    private enum OrderType {
        PREVORDER,
        INORDER,
        POSTORDERl
    }


    /**
     * 前序遍历非递归实现
     */
    public void prevorderNR() {
        if (root == null) {
            return;
        }
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.empty()) {
            Node currentNode = nodes.pop();
            //先处理当前节点，在处理左子节点，最后处理右子节点
            System.out.println(currentNode.value);
            //因为栈是FILO，所以想要先处理左节点，必须后压入左节点
            if (currentNode.right != null)
                nodes.push(currentNode.right);

            if (currentNode.left != null)
                nodes.push(currentNode.left);

        }
    }
}

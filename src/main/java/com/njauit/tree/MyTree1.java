package com.njauit.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 张文军
 * @Description: BST 二分搜索树
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/4/1021:41
 */
public class MyTree1<E extends Comparable<E>> {
    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    '}';
        }
    }

    private int size;
    private Node root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E e) {
        int oldSize = size;
        root = add(e, root);
        if (oldSize != size) {
            return true;
        }
        return false;
    }

    private Node add(E e, Node node) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) <= 0) {
            node.left = add(e, node.left);
        } else {
            node.right = add(e, node.right);
        }
        return node;
    }


    public void printTree(Node node, String str) {
        if (node == null) {
            return;
        }
        System.out.println(str + node.e);
        printTree(node.left, str + "-****");
        printTree(node.right, str + "+****");
    }

    public void printTree() {
        Node cur = root;

        Stack<Node> stack = new Stack<>();

        stack.push(cur);

        while (!stack.empty()) {
            Node node = stack.pop();
            System.out.println(node.e);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }


    }


    public void printTreeByQueue() {

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }

    }


    public static void main(String[] args) {
        MyTree1<Integer> tree1 = new MyTree1<>();

        tree1.add(1);
        tree1.add(-1);
        tree1.add(2);
        tree1.add(0);
        tree1.add(3);
        tree1.add(5);
        tree1.add(6);
        tree1.printTree(tree1.root, "");
        System.out.println("size= " + tree1.size);
        /*tree1.delMin(tree1.root);
        tree1.printTree(tree1.root, "");
        System.out.println("size= " + tree1.size);*/
        tree1.delMax(tree1.root);
        tree1.printTree(tree1.root, "");
        System.out.println("size= " + tree1.size);
    }

    public void delMin(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            if (node.left.left == null) {
                node.left = node.left.right;
                size--;
            } else {
                delMin(node.left);
            }
        }
    }
    public void delMax(Node node) {
        if (node == null) {
            return;
        }
        if (node.right!= null) {
            if (node.right.right == null) {
                System.out.println("delete the element "+ node.right.e);
                node.right = node.right.left;
                size--;
            } else {
                delMax(node.right);
            }
        }
    }

}




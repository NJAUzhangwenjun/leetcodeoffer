package com.njauit.tree;

/**
 * @author 张文军 @Description: @Company:it.njauit.cn
 * @version:1.0
 * @date 2020/4/1213:12
 */
public class MyBSTKV<K extends Comparable<K>, V> {
  private class Node {
    private K key;
    private V value;
    private Node right, left;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;


    }
  }

  private Node root;
  private int size;

  public int getSize() {
    return size;
  }

  public void add(K key, V value) {
    root = add(key, value, root);
  }

  private Node add(K key, V value, Node node) {
    if (node == null) {
      size++;
      return new Node(key, value);
    }

    if (key.compareTo(node.key) < 0) {
      node.left = add(key, value, node.left);
    } else if (key.compareTo(node.key) > 0) {
      node.right = add(key, value, node.right);
    }else{//key 相同的情况下，相当于是在做跟新操作。
      node.value = value;
    }
    return node;
  }

  public static void main(String[] args) {
    MyBSTKV<Integer, Integer> bstkv = new MyBSTKV<>();
    bstkv.add(1, 2);
    bstkv.add(2, 2);
    bstkv.add(2, 2);
    bstkv.add(-3, 6);
    bstkv.add(8, -2);

    System.out.println(bstkv.getSize());
  }
}

package com.njauit.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张文军 @Description: TODO @Company: njauit.cn
 * @version: 1.0
 * @date 2020/4/1111:27
 */
public class MyAVL<K extends Comparable<K>, V> {
  private class Node {
    private K key;
    private V value;
    private Node right, left;
    // 节点高度
    private int height;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      // 每次添加节点，新结点的高度都是 1；
      this.height = 1;
    }

    @Override
    public String toString() {
      return "Node{"
          + "key="
          + key
          + ", value="
          + value
          + ", right="
          + right
          + ", left="
          + left
          + ", height="
          + height
          + '}';
    }
  }

  /**
   * 计算节点的平衡因子
   *
   * @param node
   * @return
   */
  private int getBalanceFactor(Node node) {
    if (node == null) {
      return 0;
    } else {
      return Math.abs(getHeight(node.left) - getHeight(node.right));
    }
  }

  public int getHeight(Node node) {
    if (node != null) {
      return node.height;
    }
    return 0;
  }

  private Node root;
  private int size;

  public int getSize() {
    return size;
  }

  /**
   * 检查是否是二分搜索树,利用二分搜索树的中序遍历结果是从小到大排序的性质
   *
   * @return
   */
  private Boolean isBST() {
    List<K> kList = new ArrayList<>();
    inOrder(root, kList);
    for (int i = 1; i < kList.size(); i++) {
      if (kList.get(i - 1).compareTo(kList.get(i)) >= 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 中序遍历
   *
   * @param node
   * @param kList
   */
  private void inOrder(Node node, List<K> kList) {
    if (node == null) {
      return;
    }
    inOrder(node.left, kList);
    kList.add(node.key);
    inOrder(node.right, kList);
  }

  private Boolean isBalance() {
    return isBalance(root);
  }

  /**
   * 判断是否是平衡树（平衡因子绝对值<=1）
   *
   * @param node
   * @return
   */
  private Boolean isBalance(Node node) {
    if (node == null) {
      return true;
    }
    if (getBalanceFactor(node) > 1) {
      return false;
    }
    return isBalance(node.left) && isBalance(node.right);
  }

  public void add(K key, V value) {
    root = add(key, value, root);
  }

  /**
   * 添加节点
   *
   * @param key
   * @param value
   * @param node
   * @return
   */
  private Node add(K key, V value, Node node) {
    if (node == null) {
      size++;
      return new Node(key, value);
    }

    if (key.compareTo(node.key) < 0) {
      node.left = add(key, value, node.left);
    } else if (key.compareTo(node.key) > 0) {
      node.right = add(key, value, node.right);
    } else { // key 相同的情况下，相当于是在做跟新操作。
      node.value = value;
    }
    // 跟新 节点高度 ，选取左右子树中的最大值+1
    node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    System.out.println("node.height=" + node.height);
    System.out.println("node.key=" + node.key);
    System.out.println("getBalanceFactor=" + getBalanceFactor(node));
    return node;
  }

  public static void main(String[] args) {
    MyAVL<Integer, Integer> bstkv = new MyAVL<>();
    bstkv.add(1, 2);
    bstkv.add(2, 2);
    bstkv.add(6, 2);
    bstkv.add(-3, 6);
    bstkv.add(8, -2);

    System.out.println(bstkv.getSize());
    System.out.println(bstkv.root.toString());
    System.out.println("bstkv.isBST() ? " + bstkv.isBST());
    System.out.println("isBalance ??? "+ bstkv.isBalance());

  }
}

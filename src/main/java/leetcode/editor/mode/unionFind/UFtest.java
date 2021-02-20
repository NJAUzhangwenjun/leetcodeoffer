package leetcode.editor.mode.unionFind;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/2/2015:51
 */
public class UFtest {
  public static void main(String[] args) {
    //
    UnionFind<Integer> uf = new UN1(12);
    uf.union(0, 4);
    uf.union(0, 1);
    uf.union(0, 3);
    uf.union(2, 3);
    uf.union(2, 5);

    uf.union(10, 0);
    uf.union(6, 7);

    uf.union(9, 8);
    uf.union(9, 10);
    uf.union(9, 11);

    System.out.println(uf.isUnion(1,11));
  }
}

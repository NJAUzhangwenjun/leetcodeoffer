package leetcode.editor.mode.unionFind;

import java.util.Arrays;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/2/2013:41
 */
public class UN1 implements UnionFind<Integer> {
  private int[] IDs;

  public UN1(int size) {
    this.IDs = new int[size];
    for (int i = 0; i < IDs.length; i++) {
      IDs[i] = i;
    }
  }

  @Override
  public void union(Integer p, Integer q) {
    if (isUnion(p,q)) {
      return;
    }
    for (int i = 0; i < IDs.length; i++) {
      if (q.equals(IDs[i])) {
        IDs[i] = p;
      }
    }
  }

  @Override
  public Boolean isUnion(Integer p, Integer q) {
    System.out.println(Arrays.toString(IDs));
    return find(p).equals(find(q));
  }

  @Override
  public Integer find(Integer p) {
    return IDs[p];
  }
}

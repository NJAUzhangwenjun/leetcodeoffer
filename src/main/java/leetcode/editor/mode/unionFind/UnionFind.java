package leetcode.editor.mode.unionFind;

/**
 * @author 张文军
 * @Description:并查集接口
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/2/2013:35
 */
public interface UnionFind<E> {
  /** 连接两个元素
   * @param p index
   * @param q index
   */
  void union(E p, E q);

  /**
   * 判断 是否相连
   * @param p index
   * @param q index
   * @return
   */
  Boolean isUnion(E p, E q);

  /** 查找元素对应集合编号（根元素编号）
   * @param p index
   * @return
   */
  Integer find(E p);
}

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 787. 迷宫 中文English 在迷宫中有一个球，里面有空的空间和墙壁。球可以通过滚上，下，左或右移动， 但它不会停止滚动直到撞到墙上。当球停止时，它可以选择下一个方向。
 *
 * <p>给定球的起始位置，目的地和迷宫，确定球是否可以停在终点。
 *
 * <p>迷宫由二维数组表示。1表示墙和0表示空的空间。你可以假设迷宫的边界都是墙。开始和目标坐标用行和列索引表示。
 *
 * <p>样例 例1:
 *
 * <p>输入: map = [ [0,0,1,0,0], [0,0,0,0,0], [0,0,0,1,0], [1,1,0,1,1], [0,0,0,0,0] ] start = [0,4]
 * end = [3,2] 输出: false 例2:
 *
 * <p>输入: map = [[0,0,1,0,0], [0,0,0,0,0], [0,0,0,1,0], [1,1,0,1,1], [0,0,0,0,0] ]
 *
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/2/1723:40
 */
public class Maze {
  public static void main(String[] args) {
    //
    final Solution solution = new Maze().new Solution();
    final boolean b =
        solution.hasPath(
            new int[][] {
              {0, 0, 1, 0, 0},
              {0, 0, 0, 0, 0},
              {0, 0, 0, 1, 0},
              {1, 1, 0, 1, 1},
              {0, 0, 0, 0, 0}
            },
            new int[] {0, 4},
            new int[] {3, 2});
    System.out.println("b = " + b);
  }

  class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
      // write your code here
      if (maze == null || maze.length == 0) return false;
      return dfs(maze, start[0], start[1], destination);
    }

    final int[] xx = {1, 0, -1, 0};
    final int[] yy = {0, 1, 0, -1};

    private boolean bfs(int[][] maze, int i, int j, int[] end) {

      final Queue<int[]> queue = new LinkedList<>();
      queue.add(new int[] {i, j});
      maze[i][j] = 1;
      while (!queue.isEmpty()) {
        final int[] poll = queue.poll();
        /*判断是否到达了终点*/
        if (poll[0] == end[0] && poll[1] == end[1]) return true;

        for (int k = 0; k < 4; k++) {
          final int x = poll[0] + xx[k];
          final int y = poll[1] + yy[k];
          if (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 0) {
            queue.add(new int[] {x, y});
            maze[x][y] = 1;
          }
        }
      }
      return false;
    }

    private boolean dfs(int[][] maze, int x, int y, int[] end) {

      if (x == end[0] && y == end[1] /*到达目的*/)
        /*输出解*/
        return true;
      if (maze[x][y] == 1) return false;
      maze[x][y] = 1;
      for (int i = 0; i < 4 /* 方案数*/; i++) {
        final int x1 = x + xx[i];
        final int y1 = y + yy[i];
        if (x1 >= 0 && x1 < maze.length && y1 >= 0 && y1 < maze[0].length /*方案可行*/) {
          ps(i);
          /*递归操作*/
          if (dfs(maze, x1, y1, end)) return true;
          /*恢复保存前状态*/
          //maze[x][y] = 0;
        }
      }
      System.out.println();
      return false;
    }
  }

  public static void ps(int k) {
    switch (k) {
      case 0:
        System.out.printf("向右->");
        break;
      case 1:
        System.out.printf("向上->");
        break;
      case 2:
        System.out.printf("向左->");
        break;
      default:
        System.out.printf("向下->");
    }
  }
}

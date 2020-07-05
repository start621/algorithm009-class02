//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

  
package com.start621.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands{
  public static void main(String[] args) {
       Solution solution = new NumberOfIslands().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int numIslands(char[][] grid) {
          int count = 0;
          for(int i = 0; i < grid.length; i++) {
              for(int j = 0; j < grid[0].length; j++) {
                  if(grid[i][j] == '1'){
                      bfs(grid, i, j);
                      count++;
                  }
              }
          }
          return count;
      }
      private void bfs(char[][] grid, int i, int j) {
          Queue<int[]> list = new LinkedList<>();
          list.add(new int[]{i, j});
          while (!list.isEmpty()) {
              int[] cur = list.remove();
              i = cur[0];
              j = cur[1];
              if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
                  grid[i][j] = '0';
                  list.add(new int[]{i + 1, j});
                  list.add(new int[]{i - 1, j});
                  list.add(new int[]{i, j + 1});
                  list.add(new int[]{i, j - 1});
              }
          }
      }
//      public int numIslands(char[][] grid) {
//          if(grid.length == 0) return 0;
//          int x = grid.length;
//          int y = grid[0].length;
//
//          int[] nums = new int[x * y];
//          Arrays.fill(nums, -1);
//
//          for(int i = 0; i < x; i++) {
//              for(int j = 0; j < y; j++) {
//                  if(grid[i][j] == '1') {
//                      grid[i][j] = '0';
//
//                      //判断下侧是否有陆地
//                      if(i < (x - 1) && grid[i + 1][j] == '1') {
//                          union(nums, i * y + j, (i + 1) * y + j);
//                      }
//
//                      //判断右侧是否有陆地
//                      if(j < (y - 1) && grid[i][j + 1] == '1') {
//                          union(nums, i * y + j, i * y + j + 1);
//                      }
//                  } else {
//                      nums[i * y + j] = -2;
//                  }
//              }
//          }
//
//          int count = 0;
//          for(int num : nums) {
//              if(num == -1) count++;
//          }
//
//          return count;
//      }
//
//      public int find(int[] parents, int i) {
//          if(parents[i] == -1) {
//              return i;
//          }
//
//          return find(parents, parents[i]);
//      }
//
//      public void union(int[] parents, int x, int y) {
//          int xset = find(parents, x);
//          int yset = find(parents, y);
//          if(xset != yset) {
//              parents[xset] = yset;
//          }
//      }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

  
package com.start621.leetcode.editor.cn;

import java.util.Arrays;

public class LongestIncreasingSubsequence{
  public static void main(String[] args) {
       Solution solution = new LongestIncreasingSubsequence().new Solution();
       System.out.println(solution.lengthOfLIS(new int[]{0}));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 1;
        // dp[i] 表示数组第i个元素的最大上升序列的长度
        int length = nums.length;

        if (length == 0) return 0;

        int[] dp = new int[length];
        // 初始化 默认为1
        Arrays.fill(dp, 1);
        // dp方程 1. 如果存在nums[i] > nums[j] 则dp[i] = dp[j] + 1; 2. 如果nums[i] < mums[i-1], 则dp[i] = max(dp[j] + 1) (j in [0,i-1])
        // dp[i] = max(dp[j] + 1) j in [0, i-1]
        for (int i = 0; i < length; i++) {
            // 这一步可以考虑优化
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
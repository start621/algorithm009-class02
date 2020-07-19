//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

// 思路：直接看题目其实没有任何思路
// 这种情况的解决办法：
// 1. 分析问题是否可以暴力破解，可以枚举 2.从前面结果中，找出可重复的子问题 核心思想在与针对算法题而言，必然是可以解决的，
// 然而对于计算机而言，落地到代码层面，只能有if-else/switch，loop，recursive这3种基础操作

// 解法：在迈上最后一步台阶时，只有两种可能，要不是1步，要不是2步；即f(n) = f(n-1) + f(n-2) 即斐波拉契数列

package com.start621.leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //    public int climbStairs(int n) {
//        int t1 = 1, t2 = 2, t3 = 0;
//        if (n < 3) {
//            return n;
//        }
//
//        for (int i = 2; i < n; i++) {
//            t3 = t2 + t1;
//            t1 = t2;
//            t2 = t3;
//        }
//
//        return t3;
//    }
        // dp
        public int climbStairs(int n) {
            if (n <= 2) return n;
            // 定义状态 用于dp[i-1]存储第i级台阶的走法
            int[] dp = new int[n];
            // 初始化值
            dp[0] = 1;
            dp[1] = 2;

            for (int i = 2; i < n; i++) {
                // dp方程
                dp[i] = dp[i-1] + dp[i-2];
            }

            return dp[n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
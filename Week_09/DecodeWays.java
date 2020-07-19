//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划

  
package com.start621.leetcode.editor.cn;
public class DecodeWays{
  public static void main(String[] args) {
       Solution solution = new DecodeWays().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {

        char[] sArray = s.toCharArray();
        // 定义状态 dp[i]表示子串的解码方法数
        int[] dp = new int[s.length()];
        // 初始化
        if (sArray[0] == '0') {
            return 0;
        }
        dp[0] = 1;
        // dp方程 如果a[i] + a[i-1]*10 > 26,则dp[i]=dp[i-1];反之dp[i]=dp[i+1]  注意要考虑0的场景
        for (int i = 1; i < s.length(); i++) {
            if (sArray[i] != '0') {
                dp[i] = dp[i - 1];
            }

            int num = 10 * (sArray[i - 1] - '0') + (sArray[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length() - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
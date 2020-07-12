//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学

  
package com.start621.leetcode.editor.cn;
public class PowerOfTwo{
    // 思路一：将n不断的除以2，如果最后值为1，则表示是2的幂 时间复杂度O(log2N)
    // 思路二：利用移位的特点，x&(-x)表示将x的获取最右边的1；x&(x-1)表示将x最右边的1置为0；结合2的幂的特点，
    // 即所有位中只有一个1
  public static void main(String[] args) {
       Solution solution = new PowerOfTwo().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
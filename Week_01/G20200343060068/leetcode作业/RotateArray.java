//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


// 思路一：数组元素移动，考虑边界场景，当要移动元素的下标加上K之后，如果超出数组长度，则旋转至数组前面
package com.start621.leetcode.editor.cn;
public class RotateArray{
  public static void main(String[] args) {
       Solution solution = new RotateArray().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || k < 0) return;
        int[] tmp = new  int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            // 移动后 取模即为对应位置
            tmp[(i + k) % nums.length] = nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
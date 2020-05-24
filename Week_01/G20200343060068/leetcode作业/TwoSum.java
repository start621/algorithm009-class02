//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表
// 解法一：暴力破解 两次遍历所有数组元素 判断target == a[i] + a[j] 时间复杂度o(n2)
// 解法二：利用空间换时间 先用hash表存储数组元素，利用其K-V特性，输出对应元素的下标；一次遍历中，判断
// target - a[i] 是否在hashmap中，输出对应hash的key;
// 重点在于hash表中查找查找某个元素的时间复杂度为o(1)
  
package com.start621.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum{
  public static void main(String[] args) {
       Solution solution = new TwoSum().new Solution();
       int[] nums = new int[] {3, 2, 4};
       int target = 6;
       solution.twoSum(nums, target);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            tempMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempMap.containsKey(target - nums[i]) && (i != tempMap.get(target - nums[i]))) {
                int[] result = new int[] {i, tempMap.get(target - nums[i])};
                return result;
            }
        }

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
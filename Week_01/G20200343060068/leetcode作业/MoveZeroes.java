//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针

// 思路一：将数组转为链表，然后遍历该链表元素，如果为0则删除该元素，在末尾增加一个元素 时间复杂度为O(n) 题目为必须在原数组上操作，应该不满足要求
// 思路二：依次遍历所有元素，如果元素为0，则移动至数组最后,删除当前元素 时间复杂度为O(n^2)
// 思路三：依次遍历所有元素，如果当前元素为0，则比较后一个元素，如果不为0，则交换位置； 时间复杂度为O(n^2)

// 解法一：参考快排的思想，以数组中第一个0作为标准，非0元素移动到0的左侧；增加两个指针，分别表示当前遍历的元素和0左侧元素
// 解法二：增加指针j，用于记录当前非0元素的位置，遍历完成后将数据从j++开始赋值为0 虽然是两次for循环但是代码思路很清晰直接

  
package com.start621.leetcode.editor.cn;
public class MoveZeroes{
  public static void main(String[] args) {
       Solution solution = new MoveZeroes().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//              int tmp = nums[i];
//              nums[i] = nums[j];
//              nums[j++] = tmp;
//            }
//        }
//    }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)  {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
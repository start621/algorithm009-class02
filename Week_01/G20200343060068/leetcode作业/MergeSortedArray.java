//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3  重点
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

// 思路1：和合并有序链表类似，当
// 思路2：先合并后排序 o(n*log(n))

package com.start621.leetcode.editor.cn;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        Solution solution = new MergeSortedArray().new Solution();
        solution.merge(nums1, nums1.length, nums2, nums2.length);
        System.out.println(Arrays.asList(nums1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 先合并后排序，前提条件是num1有足够大空间
//            System.arraycopy(nums2, 0, nums1, m, n);
//            Arrays.sort(nums1);

            // 比较两者大小
            int[] tmp = new int[m];
            System.arraycopy(nums1, 0, tmp, 0, m);

            int i = 0, j = 0, k = 0;
            while (i < m && j < n) {
                nums1[k++] = tmp[i] < nums2[j] ? tmp[i++] : nums2 [j++];
            }
            // 处理某个数组多出来的元素
            if (i < m)
                System.arraycopy(tmp, i, nums1, i + j, m + n - i - j);
            if (j < n)
                System.arraycopy(nums2, j, nums1, i + j, m + n - i - j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
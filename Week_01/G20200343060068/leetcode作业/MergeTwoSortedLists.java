//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表
// 思路一： 暴力 分别两重循环，同时判断两个数组中元素的大小

package com.start621.leetcode.editor.cn;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */


    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 增加哨兵节点
            ListNode dummy = new ListNode(-1);
            ListNode previous = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    previous.next = l2;
                    l2 = l2.next;
                } else {
                    previous.next = l1;
                    l1 = l1.next;
                }
                previous = previous.next;
            }
            previous.next = l1 == null ? l2 : l1;

            return dummy.next;

        }

        // todo: 补充递归方法
    }
//leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
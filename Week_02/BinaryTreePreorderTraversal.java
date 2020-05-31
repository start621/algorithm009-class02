//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


package com.start621.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;

//            // 先序遍历 根-》左-》右
//            // 使用递归，其停止条件是什么？
              // 递归的运行逻辑如何模拟？
            // 递归如何合理的优化，中间值怎么存储？
//            list.add(root.val);
//            list.addAll(preorderTraversal(root.left));
//            list.addAll(preorderTraversal(root.right));
//            return list;

            preHelper(list, root);
            return list;
        }

        private void preHelper(List<Integer> list, TreeNode root) {
            if (root == null) return;
            list.add(root.val);
            preHelper(list, root.left);
            preHelper(list, root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


package com.start621.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 思路：既可以用BFS，也可以用DFS 只需要记录节点的层次信息，按层次输出即可

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        Integer[] data = {5,3,6,2,4,null,7};

        System.out.println(solution.levelOrder(TreeCreator.createTree(data)));
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
        public List<List<Integer>> levelOrder(TreeNode root) {
//            List<List<Integer>> result = new ArrayList<>();
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.offer(root);
//
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                List<Integer> level = new ArrayList<>();
//                for (int i = 0; i < size; i++) {
//                    TreeNode current = queue.peek();
//                    queue.poll();
//                    if (current == null) {
//                        continue;
//                    }
//                    level.add(current.val);
//                    queue.offer(current.left);
//                    queue.offer(current.right);
//                }
//                if (!level.isEmpty()) {
//                    result.add(level);
//                }
//            }
//            return result;
            List<List<Integer>> result = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList<>();
                // 记录当前层的信息
                while (size-- > 0) {
                    TreeNode current = queue.poll();

                    if (current == null) continue;

                    level.add(current.val);
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
                result.add(level);
            }
            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)


}
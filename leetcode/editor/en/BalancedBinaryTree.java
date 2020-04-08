package leetcode.editor.en;

//Given a binary tree, determine if it is height-balanced. 
//
// For this problem, a height-balanced binary tree is defined as: 
//
// 
// a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//
//
// 
//
// Example 1: 
//
// Given the following tree [3,9,20,null,null,15,7]: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// Return true. 
// 
//Example 2: 
//
// Given the following tree [1,2,2,3,3,null,null,4,4]: 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// Return false. 
// Related Topics Tree Depth-first Search


import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        TreeNode leftRight = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left = leftRight;
        rootRight.right = rightRight;
        root = new TreeNode(1);
        rootRight = new TreeNode(1);
        rightRight = new TreeNode(1);
        root.right = rootRight;
        rootRight.right = rightRight;
        solution.isBalanced(root);
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
        int deepest = 0;
        int floor = -1;
        boolean found = false;

        public boolean isBalanced(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            // 遍历的方式 不好记录当前的层级
//            TreeNode last = root;
//            int level = 0;
//            while (!queue.isEmpty()) {
//                TreeNode q = queue.remove();
//                if (q == null) {
//                    continue;
//                }
//
//                if (last.val == q.val) {
//                    level++;
//                    if (q.right != null) {
//                        last = q.right;
//                    } else if (q.left != null) {
//                        last = q.left;
//                    }
//                }
//
//            }

            return findDeep(root) != -1;
        }

        /**
         * 目的是找到两棵树最大的层级区别
         *
         * @param node
         * @return
         */
        private int findDeep(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = findDeep(node.left);
            int right = findDeep(node.right);
            if (left == -1) {
                return -1;
            }
            if (right == -1) {
                return -1;
            }

            if (Math.abs(left - right) > 1) {
                return -1;
            }

            return Math.max(left, right) + 1;
        }


        private void dfs(TreeNode x, int level) {
            if (x == null || found) {
                return;
            }

            if (x.left == null || x.right == null) {
                if (floor > level || floor == -1) {
                    floor = level;
                }
            }

            if (x.left != null) {
                dfs(x.left, level + 1);
            }

            if (x.right != null) {
                dfs(x.right, level + 1);
            }

            if (x.left == null && x.right == null) {
                if (level > deepest) {
                    deepest = level;
                }
            }

            if (deepest - floor > 1) {
                found = true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
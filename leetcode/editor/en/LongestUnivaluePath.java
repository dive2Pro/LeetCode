package leetcode.editor.en;

//Given a binary tree, find the length of the longest path where each node in
// the path has the same value. This path may or may not pass through the root.
//
// The length of path between two nodes is represented by the number of edges
// between them.
//
// 
//
// Example 1: 
//
// Input: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// Output: 2 
//
// 
//
// Example 2: 
//
// Input: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// Output: 2 
//
// 
//
// Note: The given binary tree has not more than 10000 nodes. The height of the 
//tree is not more than 1000. 
// Related Topics Tree Recursion


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath().new Solution();
        solution.longestUnivaluePath(TreeNode.generateFrom(new Object[]{5, 4, 5, 1, 1, 5}));
        solution.longestUnivaluePath(TreeNode.generateFrom(new Object[]{1, 4, 5, 4, 4, 5}));
        solution.longestUnivaluePath(TreeNode.generateFrom(new Object[]{1, null, 1, 1, 1, 1, 1, 1, 1}));
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
        private int longest = 0;

        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return longest;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = dfs(root.left);
            int right = dfs(root.right);

            left = root.left != null && root.left.val == root.val ? left + 1 : 0;
            right = root.right != null && root.right.val == root.val ? right + 1 : 0;

            longest = Math.max(longest, left + right);

            return Math.max(left, right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
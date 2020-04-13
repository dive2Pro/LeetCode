package leetcode.editor.en;

//Invert a binary tree.
//
// Example: 
//
// Input: 
//
// 
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// Output: 
//
// 
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// Trivia: 
//This problem was inspired by this original tweet by Max Howell: 
//
// Google: 90% of our engineers use the software you wrote (Homebrew), but you c
//an’t invert a binary tree on a whiteboard so f*** off. 
// Related Topics Tree


public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
        TreeNode root = new TreeNode(4);
        TreeNode rootLeft = new TreeNode(2);
        root.left = rootLeft;
        solution.invertTree(root);
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
        public TreeNode invertTree(TreeNode root) {
            if (null == root) {
                return root;
            }
            TreeNode node = new TreeNode(root.val);
            dfs(root, node);
            return node;
        }

        private void invertTree(TreeNode left, TreeNode rightParent, TreeNode right) {

        }

        private TreeNode invertTree(TreeNode node, TreeNode copy) {
            if (node == null) {
                return null;
            }

            if (copy == null) {
                copy = new TreeNode(node.val);
            }


            return copy;
        }

        private void dfs(TreeNode node, TreeNode copy) {
            if (node.right != null) {
                copy.left = new TreeNode(node.right.val);
                dfs(node.right, copy.left);
            }

            if (node.left != null) {
                copy.right = new TreeNode(node.left.val);
                dfs(node.left, copy.right);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics Tree Depth-first Search


package leetcode.editor.en;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        TreeNode root = new TreeNode(2147483644);
        TreeNode left = new TreeNode(-2147483648);
        TreeNode right = new TreeNode(2147483646);

        TreeNode rightLeft = new TreeNode(2147483645);
        TreeNode rightRight = new TreeNode(2147483647);

//        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        boolean isValidBST = solution.isValidBST(root);
        System.out.println(isValidBST);
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
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            return compareBranch(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean compareBranch(TreeNode treeNode, long min , long max) {
            if (treeNode == null) {
                return true;
            }

            if (treeNode.val <= min || treeNode.val >= max) {
                return false;
            }

            return compareBranch(treeNode.left, min, treeNode.val) && compareBranch(treeNode.right, treeNode.val, max);
        }


        private boolean compareTwoOf(TreeNode node, TreeNode node2) {
            if (node2 == null) {
                return true;
            }

            if (node == null) {
                return true;
            }

            return node.val > node2.val;
        }

        private boolean compareInSingleBinary(TreeNode treeNode) {
            return compareTwoOf(treeNode, treeNode.left) && compareTwoOf(treeNode.right, treeNode);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}

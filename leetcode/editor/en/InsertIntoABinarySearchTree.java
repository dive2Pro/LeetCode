//Given the root node of a binary search tree (BST) and a value to be inserted i
//nto the tree, insert the value into the BST. Return the root node of the BST aft
//er the insertion. It is guaranteed that the new value does not exist in the orig
//inal BST. 
//
// Note that there may exist multiple valid ways for the insertion, as long as t
//he tree remains a BST after insertion. You can return any of them. 
//
// For example, 
//
// 
//Given the tree:
//        4
//       / \
//      2   7
//     / \
//    1   3
//And the value to insert: 5
// 
//
// You can return this binary search tree: 
//
// 
//         4
//       /   \
//      2     7
//     / \   /
//    1   3 5
// 
//
// This tree is also valid: 
//
// 
//         5
//       /   \
//      2     7
//     / \   
//    1   3
//         \
//          4
// 
// Related Topics Tree


package leetcode.editor.en;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();
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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                root = new TreeNode(val);
                return root;
            }

            if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

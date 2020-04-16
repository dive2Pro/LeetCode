package leetcode.editor.en;

//Given the root of a binary tree, then value v and depth d, you need to add a r
//ow of nodes with value v at the given depth d. The root node is at depth 1. 
//
// The adding rule is: given a positive integer depth d, for each NOT null tree 
//nodes N in depth d-1, create two tree nodes with value v as N's left subtree roo
//t and right subtree root. And N's original left subtree should be the left subtr
//ee of the new left subtree root, its original right subtree should be the right 
//subtree of the new right subtree root. If depth d is 1 that means there is no de
//pth d-1 at all, then create a tree node with value v as the new root of the whol
//e original tree, and the original tree is the new root's left subtree. 
//
// Example 1: 
// 
//Input: 
//A binary tree as following:
//       4
//     /   \
//    2     6
//   / \   / 
//  3   1 5   
//
//v = 1
//
//d = 2
//
//Output: 
//       4
//      / \
//     1   1
//    /     \
//   2       6
//  / \     / 
// 3   1   5   
//
// 
// 
//
//
// Example 2: 
// 
//Input: 
//A binary tree as following:
//      4
//     /   
//    2    
//   / \   
//  3   1    
//
//v = 1
//
//d = 3
//
//Output: 
//      4
//     /   
//    2
//   / \    
//  1   1
// /     \  
//3       1
// 
// 
//
// Note: 
// 
// The given d is in range [1, maximum depth of the given tree + 1]. 
// The given binary tree has at least one tree node. 
// 
// Related Topics Tree


public class AddOneRowToTree {
    public static void main(String[] args) {
        Solution solution = new AddOneRowToTree().new Solution();
        solution.addOneRow(
                TreeNode.generateFrom(new Object[]{
                        4, 2, 6, 3, 1, 5
                }),
                1,
                2
        );
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
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            root = dfs(root, v, d, 1, true);
            return root;
        }

        TreeNode addToLeft(TreeNode root, int v) {
            TreeNode prevRoot = root;
            root = new TreeNode(v);
            root.left = prevRoot;
            return root;
        }

        TreeNode addToRight(TreeNode root, int v) {
            TreeNode prevRoot = root;
            root = new TreeNode(v);
            root.right = prevRoot;
            return root;
        }

        private TreeNode dfs(TreeNode root, int v, int deep, int currDeep, boolean isLeft) {

            if (deep == 1) {
                if (isLeft) root = addToLeft(root, v);
                else root = addToRight(root, v);
                return root;
            }

            if (root == null) {
                return null;
            }

            if (deep - 1 == currDeep) {

                root.left = dfs(root.left, v, 1, currDeep + 1, true);
                root.right = dfs(root.right, v, 1, currDeep + 1, false);
            } else {
                root.left = dfs(root.left, v, deep, currDeep + 1, true);
                root.right = dfs(root.right, v, deep, currDeep + 1, false);
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
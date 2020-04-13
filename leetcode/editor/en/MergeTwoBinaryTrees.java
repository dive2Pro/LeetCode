package leetcode.editor.en;

//Given two binary trees and imagine that when you put one of them to cover the
//other, some nodes of the two trees are overlapped while the others are not. 
//
// You need to merge them into a new binary tree. The merge rule is that if two 
//nodes overlap, then sum node values up as the new value of the merged node.
// Otherwise, the NOT null node will be used as the node of new tree.
//
// Example 1: 
//
// 
//Input: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//Output: 
//Merged tree:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 
//
// Note: The merging process must start from the root nodes of both trees. 
// Related Topics Tree


public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
        solution.mergeTrees(TreeNode.generateFrom(new Object[]{1, 2, null, 3}), TreeNode.generateFrom(new Object[]{
                1, null, 2, null, 3
        }));
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
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            TreeNode root = null;
            root = dfs(t1, t2, root);
            return root;
        }

        private TreeNode dfs(TreeNode t1, TreeNode t2, TreeNode node) {
            int val = 0;
            if (t1 == null && t2 == null) {
                return null;
            }
            if (node == null) {
                node = new TreeNode(val);
            }

            if (t1 == null) {
                val = t2.val;
                node.left = dfs(null, t2.left, node.left);
                node.right = dfs(null, t2.right, node.right);
            } else if (t2 == null) {
                val = t1.val;
                node.left = dfs(t1.left, null, node.left);
                node.right = dfs(t1.right, null, node.right);
            } else {
                val = t1.val + t2.val;
                node.left = dfs(t1.left, t2.left, node.left);
                node.right = dfs(t1.right, t2.right, node.right);
            }

            node.val = val;

            return node;
        }

        ;

    }
//leetcode submit region end(Prohibit modification and deletion)


}
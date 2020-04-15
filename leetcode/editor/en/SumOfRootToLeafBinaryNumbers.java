package leetcode.editor.en;

//Given a binary tree, each node has value 0 or 1. Each root-to-leaf path repres
//ents a binary number starting with the most significant bit. For example, if the
// path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which
// is 13. 
//
// For all leaves in the tree, consider the numbers represented by the path from
// the root to that leaf. 
//
// Return the sum of these numbers. 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input: [1,0,1,0,1,0,1]
//Output: 22
//Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// 
//
// 
//
// Note: 
//
// 
// The number of nodes in the tree is between 1 and 1000. 
// node.val is 0 or 1. 
// The answer will not exceed 2^31 - 1. 
// 
// Related Topics Tree


import java.util.List;

public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfRootToLeafBinaryNumbers().new Solution();
        solution.sumRootToLeaf(TreeNode.generateFrom(new Object[]{
                1,0,1,0,1,0,1
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
        int total = 0 ;
        public int sumRootToLeaf(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            return total;
        }

        private void dfs(TreeNode root, StringBuilder sb) {
            if(root == null) {
                return;
            }
            int size = sb.length();
            sb.append(root.val);
            if(root.left == null && root.right == null) {
                 total += Long.parseLong(sb.toString(), 2);
            } else {
                dfs(root.left, sb);
                dfs(root.right, sb);
            }
            sb.setLength(size);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
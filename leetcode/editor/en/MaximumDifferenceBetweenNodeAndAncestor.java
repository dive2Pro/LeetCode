package leetcode.editor.en;

//Given the root of a binary tree, find the maximum value V for which there exis
//ts different nodes A and B where V = |A.val - B.val| and A is an ancestor of B. 
//
//
// (A node A is an ancestor of B if either: any child of A is equal to B, or any
// child of A is an ancestor of B.) 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input: [8,3,10,1,6,null,14,null,null,4,7,13]
//Output: 7
//Explanation: 
//We have various ancestor-node differences, some of which are given below :
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//Among all possible differences, the maximum value of 7 is obtained by |8 - 1| 
//= 7.
// 
//
// 
//
// Note: 
//
// 
// The number of nodes in the tree is between 2 and 5000. 
// Each node will have value between 0 and 100000. 
// 
// Related Topics Tree Depth-first Search


import java.util.ArrayList;
import java.util.Collections;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        Solution solution = new MaximumDifferenceBetweenNodeAndAncestor().new Solution();
        solution.maxAncestorDiff(TreeNode.generateFrom(new Object[]{
                8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13
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
        public int maxAncestorDiff(TreeNode root) {
            int[] max = new int[1];
            dfs(root, new int[]{-1, -1}, max);
            return max[0];
        }

        private void dfs(TreeNode root, int[] ints, int[] max) {
            if (root == null) return;

            int[] originMax = new int[]{ints[0], ints[1]};

            if (ints[1] == -1) {
                ints[1] = root.val;
                ints[0] = root.val;
            } else {
                if (root.val > ints[1]) {
                    ints[1] = root.val;
                } else if (root.val < ints[0]) {
                    ints[0] = root.val;
                }
            }
            int r = Math.abs(ints[0] - ints[1]);
            max[0] = Math.max(r, max[0]);
            dfs(root.left, ints, max);
            dfs(root.right, ints, max);

            // replace to origin Max;
            ints[0] = originMax[0];
            ints[1] = originMax[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
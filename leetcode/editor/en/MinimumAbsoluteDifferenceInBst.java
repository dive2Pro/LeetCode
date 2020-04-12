//Given a binary search tree with non-negative values, find the minimum absolute
// difference between values of any two nodes. 
//
// Example: 
//
// 
//Input:
//
//   1
//    \
//     3
//    /
//   2
//
//Output:
//1
//
//Explanation:
//The minimum absolute difference is 1, which is the difference between 2 and 1 
//(or between 2 and 3).
// 
//
// 
//
// Note: 
//
// 
// There are at least two nodes in this BST. 
// This question is the same as 783:
// https://leetcode.com/problems/minimum-distance-between-bst-nodes/
// 
// Related Topics Tree


package leetcode.editor.en;

import java.util.TreeSet;

public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution =
                new MinimumAbsoluteDifferenceInBst().new Solution();
        solution.getMinimumDifference(TreeNode.generateFrom(new Object[]{
                1, null, 5, 3, null, null, 8, 0
        }));
    }

    //  leetcode submit region begin(Prohibit modification and deletion)

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
        private int minumum = Integer.MAX_VALUE;
        private TreeNode prev;

        public int getMinimumDifference(TreeNode root) {
            TreeSet<Integer> treeSet = new TreeSet<>();
//            prev = root;
            treeSet.add(root.val);
//            dfs(root.left, treeSet);
//            dfs(root.right, treeSet);
            int result = dfs(root);
            return result;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return minumum;
            }
            dfs(node.left);

            if (prev != null) {
                minumum = Math.min(minumum, Math.abs(node.val - prev.val));
            }

            prev = node;

            dfs(node.right);

            return minumum;
        }

        private void dfs(TreeNode node, TreeSet<Integer> treeSet) {
            if (node == null) {
                return;
            }

            if (minumum == 0 || treeSet.contains(node.val)) {
                minumum = 0;
                return;
            }


            Object ceilingObj = treeSet.ceiling(node.val);
            int ceiling = Integer.MAX_VALUE;
            if (ceilingObj != null) {
                ceiling = (int) ceilingObj;
            }
            Object floorObj = treeSet.floor(node.val);
            int floor = Integer.MAX_VALUE;
            if (floorObj != null) {
                floor = (int) floorObj;
            }
            treeSet.add(node.val);
            int min = Math.min(Math.abs(ceiling - node.val),
                    Math.abs(node.val - floor));

            if (min < minumum) {
                minumum = min;
            }
            dfs(node.left, treeSet);
            dfs(node.right, treeSet);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

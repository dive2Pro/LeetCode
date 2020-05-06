package leetcode.editor.en;

//
//Given a binary tree, find the leftmost value in the last row of the tree. 
// 
//
// Example 1: 
// 
//Input:
//
//    2
//   / \
//  1   3
//
//Output:
//1
// 
// 
//
// Example 2: 
// 
//Input:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//Output:
//7
// 
// 
//
// Note:
//You may assume the tree (i.e., the given root node) is not NULL.
// Related Topics Tree Depth-first Search Breadth-first Search


import java.util.HashMap;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
        solution.findBottomLeftValue(TreeNode.generateFrom(new Object[]{
                1, 2, 3, 4, null, 5, 6, null, null, 7
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
        public int findBottomLeftValue(TreeNode root) {
            int[] currLevel = new int[1];
            int[] result = new int[]{root.val};
            dfs(root, currLevel, result, 1);
            return result[0];
        }

        private void dfs(TreeNode root, int[] currLevel, int[] result, int level) {
            if (root == null) {
                return;
            }
            if (currLevel[0] != level && currLevel[0] < level) {
                currLevel[0] = level;
                result[0] = root.val;
            }
            dfs(root.left, currLevel, result, level + 1);
            dfs(root.right, currLevel, result, level + 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
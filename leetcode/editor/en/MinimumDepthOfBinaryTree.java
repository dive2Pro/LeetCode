package leetcode.editor.en;

//Given a binary tree, find its minimum depth.
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given binary tree [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// return its minimum depth = 2. 
// Related Topics Tree Depth-first Search Breadth-first Search


public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();

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
        public int minDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            return minDepth(root, 1);
        }

        private int minDepth(TreeNode node, int level) {

            if (node == null) {
                return Integer.MAX_VALUE;
            }


            if (node.left == null && node.right == null) {
                return level;
            }

            int left = minDepth(node.left, level + 1);
            int right = minDepth(node.right, level + 1);

            return Math.min(left, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
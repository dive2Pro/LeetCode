package leetcode.editor.en;

//Given a complete binary tree, count the number of nodes.
//
// Note: 
//
// Definition of a complete binary tree from Wikipedia:
//In a complete binary tree every level, except possibly the last, is completely
// filled, and all nodes in the last level are as far left as possible.
// It can have between 1 and 2h nodes inclusive at the last level h.
//
// Example: 
//
// 
//Input: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//Output: 6 
// Related Topics Binary Search Tree


public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
        solution.countNodes(TreeNode.generateFrom(new Object[]{
//                1, 2, 3, 4, 5, 6, 7, 8
                1, 2, 3, 4, 5, 6
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
        private int count = 1;
        boolean canStop = false;

        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int deepest = findDeep(root);
            int total = 1;
            for (int i = 1; i < deepest; i++) {
                count += Math.pow(2, i);

            }
            dfsr(root, 1, deepest);
            return count;
        }

        private int findDeep(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return findDeep(root.left) + 1;
        }

        private void dfsr(TreeNode root, int level, int deepest) {
            if (root == null || canStop) {
                return;
            }
            if (level == deepest - 1) {
                if (root.right == null && root.left == null) {
                    count -= 2;
                } else if (root.right == null) {
                    count--;
                    canStop = true;
                }
            }

            dfsr(root.right, level + 1, deepest);
            dfsr(root.left, level + 1, deepest);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
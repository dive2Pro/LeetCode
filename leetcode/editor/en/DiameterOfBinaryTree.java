//
//Given a binary tree, you need to compute the length of the diameter of the tre
//e. The diameter of a binary tree is the length of the longest path between any t
//wo nodes in a tree. This path may or may not pass through the root.
// 
//
// 
//Example: 
//Given a binary tree 
// 
//          1
//         / \
//        2   3
//       / \     
//      4   5    
// 
// 
// 
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
// 
//
// Note:
//The length of path between two nodes is represented by the number of edges bet
//ween them.
// Related Topics Tree


package leetcode.editor.en;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        int length =
                solution.diameterOfBinaryTree(TreeNode.generateFrom(new Object[]{
                        4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6,
                        null, -6, -6, null, null, 0, 6, 5, null, 9, null,
                        null, -1, -4, null, null, null, -2
                }));

        System.out.println(length);
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
        private int max = Integer.MIN_VALUE;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return max;
        }


        int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = dfs(node.left);
            int right = dfs(node.right);
            if (max < left + right) {
                max = left + right;
            }
            return Math.max(left, right) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

package leetcode.editor.en;

//Given the root of a binary tree with N nodes, each node in the tree has node.v
//al coins, and there are N coins total. 
//
// In one move, we may choose two adjacent nodes and move one coin from one node
// to another. (The move may be from parent to child, or from child to parent.) 
//
// Return the number of moves required to make every node have exactly one coin.
// 
//
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: [3,0,0]
//Output: 2
//Explanation: From the root of the tree, we move one coin to its left child, an
//d one coin to its right child.
// 
//
// 
// Example 2: 
//
// 
//
// 
//Input: [0,3,0]
//Output: 3
//Explanation: From the left child of the root, we move two coins to the root [t
//aking two moves].  Then, we move one coin from the root of the tree to the right
// child.
// 
//
// 
// Example 3: 
//
// 
//
// 
//Input: [1,0,2]
//Output: 2
// 
//
// 
// Example 4: 
//
// 
//
// 
//Input: [1,0,0,null,3]
//Output: 4
// 
//
// 
//
// Note: 
//
// 
// 1<= N <= 100 
// 0 <= node.val <= N 
// 
// 
// 
// 
// Related Topics Tree Depth-first Search


public class DistributeCoinsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DistributeCoinsInBinaryTree().new Solution();
        solution.distributeCoins(TreeNode.generateFrom(new Object[]{
                0, 0, 4, 0, null, null, null, 0, 2
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
        int count = 0;

        public int distributeCoins(TreeNode root) {
            dfs(root, 0);
            return count;
        }

        private int dfs(TreeNode node, int level) {
            if (node == null) return 0;
            int nextLevel = level - 1;
            int left = dfs(node.left, nextLevel);
            int right = dfs(node.right, nextLevel);

            int returned = 0;
            if (node.val == 0) {
                returned = -1;
            } else if (node.val > 1) {
                returned = node.val - 1;
            }
            count += Math.abs(left) + Math.abs(right);
            returned = left + right + returned;
            return returned;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
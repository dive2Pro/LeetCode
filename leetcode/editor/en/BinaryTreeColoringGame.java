package leetcode.editor.en;

//Two players play a turn based game on a binary tree. We are given the root of
//this binary tree, and the number of nodes n in the tree. n is odd, and each node
// has a distinct value from 1 to n. 
//
// Initially, the first player names a value x with 1 <= x <= n, and the second 
//player names a value y with 1 <= y <= n and y != x. The first player colors the 
//node with value x red, and the second player colors the node with value y blue. 
//
//
// Then, the players take turns starting with the first player. In each turn, th
//at player chooses a node of their color (red if player 1, blue if player 2) and 
//colors an uncolored neighbor of the chosen node (either the left child, right ch
//ild, or parent of the chosen node.) 
//
// If (and only if) a player cannot choose such a node in this way, they must pa
//ss their turn. If both players pass their turn, the game ends, and the winner is
// the player that colored more nodes. 
//
// You are the second player. If it is possible to choose such a y to ensure you
// win the game, return true. If it is not possible, return false. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
//Output: true
//Explanation: The second player can choose the node with value 2.
// 
//
// 
// Constraints: 
//
// 
// root is the root of a binary tree with n nodes and distinct node values from 
//1 to n. 
// n is odd. 
// 1 <= x <= n <= 100 
// 
// Related Topics Tree Depth-first Search


public class BinaryTreeColoringGame {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeColoringGame().new Solution();
        solution.btreeGameWinningMove(
                TreeNode.generateFrom(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}),
                11,
                3
        );
        solution.btreeGameWinningMove(TreeNode.generateFrom(new Object[]{1, 2, 3}), 3, 1);
        solution.btreeGameWinningMove(TreeNode.generateFrom(new Object[]{
                3, null, 6, null, 7, 4, null, 1, 2, null, null, 5
        }), 7, 4);
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

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            // 1. 找到 x
            // 2. 检查 x 和其之后有多少
            // 3. 将计算的和 与 n 进行比较
            // 4. 如果比较的结果小于 n 的一半 返回 false
            // 5. 如果大于 n 的一半  并且其左右子树也小于 n 的一半时  才返回 false;
            // 6. 接 5, 左右子树有某条大于 n 的一半, 返回 false;
            return dfs(root, n, x, false) != -1;
        }

        private int dfs(TreeNode root, int n, int x, boolean isUnderCount) {
            if (root == null) return 0;

            isUnderCount = isUnderCount || x == root.val;
            int left = dfs(root.left, n, x, isUnderCount);
            int right = dfs(root.right, n, x, isUnderCount);
            if (x == root.val) {
                int t = left + right + 1;
                if (t > n / 2) {
                    if (left < n / 2.0 && right < n / 2.0) {
                        return -1;
                    }
                }
            }

            return left + right + (isUnderCount ? 1 : 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
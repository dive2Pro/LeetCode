package leetcode.editor.en;

//Given a binary tree, return the sum of values of its deepest leaves.
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//Output: 15
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is between 1 and 10^4. 
// The value of nodes is between 1 and 100. 
// Related Topics Tree Depth-first Search


import javafx.util.Pair;

public class DeepestLeavesSum {
    public static void main(String[] args) {
        Solution solution = new DeepestLeavesSum().new Solution();
        int total = solution.deepestLeavesSum(TreeNode.generateFrom(new Object[]{
                1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8
        }));
        System.out.println(total);
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

    class Pair {
        Integer key;
        Integer total;

        public Pair(Integer key, Integer total) {
            this.key = key;
            this.total = total;
        }
    }

    /**
     * Sum Of deepest leaves
     */
    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            return dfs(root, 0).total;
        }

        private Pair dfs(TreeNode root, int level) {
            if (root == null) {
                return new Pair(level, 0);
            }
            Pair left = dfs(root.left, level + 1);
            Pair right = dfs(root.right, level + 1);
            if (root.left == null && root.right == null) {
                return new Pair(level, root.val);
            }
            if (left.key > right.key) {
                return left;
            } else if (left.key == right.key) {
                return new Pair(left.key, left.total + right.total);
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
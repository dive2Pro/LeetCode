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

import java.util.LinkedList;

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
            Pair p = new Pair(0, 0);
            helper(root, 0, p);
            return bfs(root);
        }

        int bfs(TreeNode node) {
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(node);
            int res = 0, i = 0;
            while (!list.isEmpty()) {
                int size = list.size();
                for (i = 0, res = 0; i < size; i++) {
                    TreeNode n = list.poll();
                    res += n.val;
                    if (n.right != null) list.add(n.right);
                    if (n.left != null) list.add(n.left);
                }
            }
            return res;
        }

        void helper(TreeNode node, int level, Pair sum) {
            if (node == null) return;
            if (node.left == null && node.right == null)
                if (level > sum.key) {
                    sum.key = level;
                    sum.total = node.val;
                } else if (level == sum.key) {
                    sum.total += node.val;
                }
            helper(node.left, level + 1, sum);
            helper(node.right, level + 1, sum);
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
            } else if (left.key.equals(right.key)) {
                return new Pair(left.key, left.total + right.total);
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
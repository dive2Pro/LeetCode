package leetcode.editor.en;

//You are given a binary tree in which each node contains an integer value.
//
// Find the number of paths that sum to a given value. 
//
// The path does not need to start or end at the root or a leaf, but it must go downwards
//(traveling only from parent nodes to child nodes). 
//
// The tree has no more than 1,000 nodes and the values are in the range -1,000,
//000 to 1,000,000.
//
// Example:
// 
//root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//Return 3. The paths that sum to 8 are:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3. -3 -> 11
// 
// Related Topics Tree


import java.util.HashMap;

public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
//        TreeNode root = TreeNode.generateFrom(new Object[]{1, -2, -3, 1, 3, -2, null, -1});
        TreeNode root = TreeNode.generateFrom(new Object[]{1, -2, -3, 1, 3, -2, null, -1});
        System.out.println(root);
        solution.pathSum(root, -1);
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
        int sum;
        int count = 0;

        public int pathSum(TreeNode root, int sum) {

            if (root == null) {
                return 0;
            }
            this.sum = sum;
            dfs(root);
            return count;
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            pathFind(node, 0);
            dfs(node.left);
            dfs(node.right);
        }

        private void pathFind(TreeNode node, int total) {
            if (node == null) {
                return;
            }
            total += node.val;

            if (total == sum) {
                count++;
            }

            pathFind(node.left, total);
            pathFind(node.right, total);
        }

        private int bestSolution(TreeNode root, int currSum, int target, HashMap<Integer, Integer> prevSums) {
            if (root == null) {
                return 0;
            }

            currSum += root.val;

            int res = prevSums.getOrDefault(currSum - target, 0);

            prevSums.put(currSum, prevSums.getOrDefault(currSum, 0) + 1);

            res += bestSolution(root.left, currSum, target, prevSums) + bestSolution(root.right, currSum, target, prevSums);

            prevSums.put(currSum, prevSums.getOrDefault(currSum, 0) - 1);

            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}
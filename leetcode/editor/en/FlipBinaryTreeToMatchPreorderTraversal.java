package leetcode.editor.en;

//Given a binary tree with N nodes, each node has a different value from {1, ...
//, N}. 
//
// A node in this binary tree can be flipped by swapping the left child and the 
//right child of that node. 
//
// Consider the sequence of N values reported by a preorder traversal starting f
//rom the root. Call such a sequence of N values the voyage of the tree. 
//
// (Recall that a preorder traversal of a node means we report the current node'
//s value, then preorder-traverse the left child, then preorder-traverse the right
// child.) 
//
// Our goal is to flip the least number of nodes in the tree so that the voyage 
//of the tree matches the voyage we are given. 
//
// If we can do so, then return a list of the values of all nodes flipped. You m
//ay return the answer in any order. 
//
// If we cannot do so, then return the list [-1]. 
//
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,2], voyage = [2,1]
//Output: [-1]
// 
//
// 
// Example 2: 
//
// 
//
// 
//Input: root = [1,2,3], voyage = [1,3,2]
//Output: [1]
// 
//
// 
// Example 3: 
//
// 
//
// 
//Input: root = [1,2,3], voyage = [1,2,3]
//Output: []
// 
//
// 
//
// Note: 
//
// 
// 1 <= N <= 100 
// 
// 
// 
// 
// Related Topics Tree Depth-first Search


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new FlipBinaryTreeToMatchPreorderTraversal().new Solution();
//        solution.flipMatchVoyage(TreeNode.generateFrom(new Object[]{
//                1, 2
//        }), new int[]{2, 1});

//        solution.flipMatchVoyage(TreeNode.generateFrom(new Object[]{
//                1, 2, 3
//        }), new int[]{1, 3, 2});

        solution.flipMatchVoyage(TreeNode.generateFrom(new Object[]{
                2, 1, 4, 5, null, 3
        }), new int[]{2, 4, 3, 1, 5});
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
        int count = 0 ;
        List<Integer> res;
        public List<Integer> flipMatchVoyage(TreeNode node, int[] voyage) {
            res = new ArrayList<>();
            return dfs(node, voyage) ? res : Arrays.asList(-1);
        }

        private boolean dfs(TreeNode node, int[] voyage) {
            if(node == null) return true;
            if(node.val != voyage[count++]) return false;
            if(node.left != null && node.left.val != voyage[count]) {
                res.add(node.val);
                return dfs(node.right, voyage) && dfs(node.left, voyage);
            }

            return dfs(node.left, voyage) && dfs(node.right, voyage);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
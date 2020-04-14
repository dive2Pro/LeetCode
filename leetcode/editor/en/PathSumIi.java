package leetcode.editor.en;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's s
//um equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics Tree Depth-first Search


import java.util.ArrayList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
        solution.pathSum(TreeNode.generateFrom(new Object[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22);
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> list = new ArrayList<>();

            dfs(root, sum, list, 0, new ArrayList<>());

            return list;
        }

        private void dfs(TreeNode root, int sum, List<List<Integer>> list, int total, ArrayList<Integer> integers) {
            if (root == null) return;
            total += root.val;

            integers.add(root.val);
            if (root.left == null && root.right == null) {
                if (total == sum) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    list.add(arrayList);
                    for (Integer integer : integers) {
                        arrayList.add(integer);
                    }
                }
            } else {
                dfs(root.left, sum, list, total, integers);
                dfs(root.right, sum, list, total, integers);
            }
            integers.remove(integers.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
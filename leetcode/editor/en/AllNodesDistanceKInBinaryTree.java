package leetcode.editor.en;

//We are given a binary tree (with root node root), a target node, and an intege
//r value K. 
//
// Return a list of the values of all nodes that have a distance K from the targ
//et node. The answer can be returned in any order. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//
//Output: [7,4,1]
//
//Explanation: 
//The nodes that are a distance 2 from the target node (with value 5)
//have values 7, 4, and 1.
//
//
//
//Note that the inputs "root" and "target" are actually TreeNodes.
//The descriptions of the inputs above are just serializations of these objects.
//
// 
//
// 
//
// Note: 
//
// 
// The given tree is non-empty. 
// Each node in the tree has unique values 0 <= node.val <= 500. 
// The target node is a node in the tree. 
// 0 <= K <= 1000. 
// 
// 
// Related Topics Tree Depth-first Search Breadth-first Search


import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
        solution.distanceK(TreeNode.generateFrom(new Object[]{
                3, 5, 1, 6, 2, 0, 8, null, null, 7, 4
        }), new TreeNode(5), 2);

        solution.distanceK(TreeNode.generateFrom(new Object[]{
                0, 1, null, 3, 2
        }), new TreeNode(2), 1);

        solution.distanceK(TreeNode.generateFrom(new Object[]{
                0, null, 1, null, 2, null, 3
        }), new TreeNode(1), 2);

        solution.distanceK(TreeNode.generateFrom(new Object[]{
                0, 2, 1, null, null, 3
        }), new TreeNode(3), 3);

        solution.distanceK(TreeNode.generateFrom(new Object[]{
                0, 1, null, null, 2, null, 3, null, 4
        }), new TreeNode(3), 0);

        solution.distanceK(TreeNode.generateFrom(new Object[]{
                0, 5, 1, null, null, 2, 6, null, 3, null, null, 4, null, 7
        }), new TreeNode(7), 3);
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
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> list = new ArrayList<>();

            dfs(root, list, target, K);
            return list;
        }

        int dfs(TreeNode root, List<Integer> list, TreeNode target, int k) {
            if (root == null) return -1;
            if (root.val == target.val) {
                // 往下寻找
                if (k == 0) {
                    list.add(root.val);
                    return -1;
                }
                dfs(root.left, list, k);
                dfs(root.right, list, k);
                return k;
            }
            // 往上寻找
            int left = dfs(root.left, list, target, k);
            int right = dfs(root.right, list, target, k);

            left--;
            right--;
            if (left < 0) {
                // 什么都不做
            } else if (left == 0) {
                // 找到了
                list.add(root.val);
            } else {
                // 还在找 从右边找
                dfs(root.right, list, left);
                return left;
            }

            if (right < 0) {
                // 什么都不做
            } else if (right == 0) {
                // 找到了
                list.add(root.val);
            } else {
                // 还在找
                dfs(root.left, list, right);
                return right;
            }

            return -1;
        }

        private void dfs(TreeNode root, List<Integer> list, int k) {
            if (root == null) return;
            k--;
            if (k == 0) {
                list.add(root.val);
            } else {
                dfs(root.left, list, k);
                dfs(root.right, list, k);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
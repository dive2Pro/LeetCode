package leetcode.editor.en;

//Given the root of a binary tree, each node in the tree has a distinct value.
//
// After deleting all nodes with a value in to_delete, we are left with a forest
// (a disjoint union of trees). 
//
// Return the roots of the trees in the remaining forest. You may return the res
//ult in any order. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
//Output: [[1,2,null,4],[6],[7]]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree is at most 1000. 
// Each node has a distinct value between 1 and 1000. 
// to_delete.length <= 1000 
// to_delete contains distinct values between 1 and 1000. 
// Related Topics Tree Depth-first Search


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        Solution solution = new DeleteNodesAndReturnForest().new Solution();
        solution.delNodes(TreeNode.generateFrom(new Object[]{
                1, 2, 3, 4, 5, 6, 7
        }), new int[]{ 3, 5});
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

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> nodes = new ArrayList<>();
            List<Integer> ints = new ArrayList<>();
            for (int value : to_delete) {
                ints.add(value);
            }
            nodes.add(root);
            dfs(nodes, root, ints);
            return nodes;
        }

        private TreeNode dfs(List<TreeNode> nodes, TreeNode root, List<Integer> to_delete) {
            if (root == null) return null;
            if (ifSideAndDelete(to_delete, root.val)) {
                for (int i = 0; i < nodes.size(); i++) {
                    if (nodes.get(i).val == root.val) {
                        nodes.remove(i);
                        break;
                    }
                }
                if (root.left != null) nodes.add(root.left);
                if (root.right != null) nodes.add(root.right);
                dfs(nodes, root.left, to_delete);
                dfs(nodes, root.right, to_delete);
                root = null;
            } else {
                root.left = dfs(nodes, root.left, to_delete);
                root.right = dfs(nodes, root.right, to_delete);
            }

            return root;
        }

        private boolean ifSideAndDelete(List<Integer> to_delete, int val) {
            for (int i = 0; i < to_delete.size(); i++) {
                if (to_delete.get(i) == val) {
                    to_delete.remove(i);
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
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
import java.util.HashMap;
import java.util.List;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        Solution solution = new DeleteNodesAndReturnForest().new Solution();
//        solution.delNodes(TreeNode.generateFrom(new Object[]{
//                1, 2, 3, 4, 5, 6, 7
//        }), new int[]{3, 5});

        solution.delNodes(TreeNode.generateFrom(new Object[]{
                1, 2, null, 4, 3
        }), new int[]{2, 3});
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
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int value : to_delete) {
                map.put(value, 1);
            }
            helper(nodes, root, true, map);
            return nodes;
        }

        TreeNode helper(List<TreeNode> list, TreeNode node, boolean isRoot, HashMap<Integer, Integer> toDelete) {
            if (node == null) return null;
            boolean isDeleted = toDelete.containsKey(node.val);
            if (isRoot && !isDeleted) list.add(node);
            node.left = helper(list, node.left, isDeleted, toDelete);
            node.right = helper(list, node.right, isDeleted, toDelete);
            return isDeleted ? null : node;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
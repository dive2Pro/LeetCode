package leetcode.editor.en;

//Given a binary tree, return all duplicate subtrees. For each kind of duplicate
// subtrees, you only need to return the root node of any one of them. 
//
// Two trees are duplicate if they have the same structure with same node values
//. 
//
// Example 1: 
//
// 
//        1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// The following are two duplicate subtrees: 
//
// 
//      2
//     /
//    4
// 
//
// and 
//
// 
//    4
// 
//Therefore, you need to return above trees' root in the form of a list. Related
// Topics Tree


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
        solution.findDuplicateSubtrees(TreeNode.generateFrom(new Object[]{
                1, 2, 3, 4, null, 2, 4, null, null, 4
//                0, 0, 0, 0, null, null, 0, null, null, null, 0
        }));

        solution.findDuplicateSubtrees(TreeNode.generateFrom(new Object[]{
//                1, 2, 3, 4, null, 2, 4, null, null, 4
                0, 0, 0, 0, null, null, 0, null, null, null, 0
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
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            ArrayList<TreeNode> total = new ArrayList<>();
            if (root == null) {
                return total;
            }
            HashMap<String, Integer> map = new HashMap<>();
            dfs(root.left, total, new StringBuilder(), map);
            dfs(root.right, total, new StringBuilder(), map);
            return total;
        }

        private String dfs(TreeNode root, ArrayList<TreeNode> total, StringBuilder stringBuilder, HashMap<String, Integer> map) {
            if (root == null) {
                return "X";
            }
            String left = dfs(root.left, total, stringBuilder, map);
            int offset = stringBuilder.length();
            stringBuilder.append(left);
            stringBuilder.insert(offset, root.val);
            String leftAndMid = stringBuilder.toString();
            stringBuilder.setLength(0);
            String right = dfs(root.right, total, stringBuilder, map);
            stringBuilder.append(leftAndMid);
            stringBuilder.append(right);
            String result = stringBuilder.toString();
            int val = map.getOrDefault(result, 0) + 1;
            map.put(result, val);
            if (val == 2) {
                total.add(0, root);
            }
            stringBuilder.setLength(0);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
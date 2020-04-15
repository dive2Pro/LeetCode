package leetcode.editor.en;

//You need to find the largest value in each row of a binary tree.
//
// Example: 
// 
//Input: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//Output: [1, 3, 9]
// 
// 
// Related Topics Tree Depth-first Search Breadth-first Search


import java.util.*;

public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
        solution.largestValues(TreeNode.generateFrom(new Object[]{
                1,3,2,5,3,null,9
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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            dfs(root, map, 0);
            list.addAll(map.values());
            return list;
        }

        private void dfs(TreeNode root, HashMap<Integer, Integer> map, int level) {
            if (root == null) return;
            if (map.get(level) == null) {
                map.put(level, root.val);
            } else if (map.get(level) < root.val) {
                map.put(level, root.val);
            }
            dfs(root.left, map, level + 1);
            dfs(root.right, map, level + 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
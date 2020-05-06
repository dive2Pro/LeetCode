package leetcode.editor.en;

//Given a binary tree, return the vertical order traversal of its nodes values.
//
//
// For each node at position (X, Y), its left and right children respectively wi
//ll be at positions (X-1, Y-1) and (X+1, Y-1). 
//
// Running a vertical line from X = -infinity to X = +infinity, whenever the ver
//tical line touches some nodes, we report the values of the nodes in order from t
//op to bottom (decreasing Y coordinates). 
//
// If two nodes have the same position, then the value of the node that is repor
//ted first is the value that is smaller. 
//
// Return an list of non-empty reports in order of X coordinate. Every report wi
//ll have a list of values of nodes. 
//
// 
//
// Example 1: 
//
// 
//
// 
// 
//Input: [3,9,20,null,null,15,7]
//Output: [[9],[3,15],[20],[7]]
//Explanation: 
//Without loss of generality, we can assume the root node is at position (0, 0):
//
//Then, the node with value 9 occurs at position (-1, -1);
//The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
//The node with value 20 occurs at position (1, -1);
//The node with value 7 occurs at position (2, -2).
// 
//
// 
// Example 2: 
//
// 
//
// 
//Input: [1,2,3,4,5,6,7]
//Output: [[4],[2],[1,5,6],[3],[7]]
//Explanation: 
//The node with value 5 and the node with value 6 have the same position accordi
//ng to the given scheme.
//However, in the report "[1,5,6]", the node value of 5 comes first since 5 is s
//maller than 6.
// 
//
// 
// 
//
// Note: 
//
// 
// The tree will have between 1 and 1000 nodes. 
// Each node's value will be between 0 and 1000. 
// 
// 
//
// 
// 
// 
// Related Topics Hash Table Tree


import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new VerticalOrderTraversalOfABinaryTree().new Solution();
        solution.verticalTraversal(TreeNode.generateFrom(new Object[]{
                3, 9, 20, null, null, 15, 7
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
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            dfs(root, map, 0, 0);
            return list;
        }

        void insertTo(List<Integer> list, int val) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > 0) {
                    list.add(i, val);
                    break;
                }
            }
        }

        private void dfs(TreeNode root, Map<Integer, List<Integer>> map, int x, int y) {
            if (root == null) return;
            map.putIfAbsent(x, new ArrayList<>());
            if (map.get(x).size() <= y) {
                map.get(x).add(root.val);
            } else {
                map.get(x).add(root.val);
            }

            insertTo(map.get(x), root.val);
            dfs(root.left, map, x - 1, y + 1);
            dfs(root.right, map, x + 1, y + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
package leetcode.editor.en;

//Given a binary tree, write a function to get the maximum width of the given tr
//ee. The width of a tree is the maximum width among all levels. The binary tree h
//as the same structure as a full binary tree, but some nodes are null. 
//
// The width of one level is defined as the length between the end-nodes (the le
//ftmost and right most non-null nodes in the level, where the null nodes between 
//the end-nodes are also counted into the length calculation. 
//
// Example 1: 
//
// 
//Input: 
//
//           1
//         /   \
//        3     2
//       / \     \  
//      5   3     9 
//
//Output: 4
//Explanation: The maximum width existing in the third level with the length 4 (
//5,3,null,9).
// 
//
// Example 2: 
//
// 
//Input: 
//
//          1
//         /  
//        3    
//       / \       
//      5   3     
//
//Output: 2
//Explanation: The maximum width existing in the third level with the length 2 (
//5,3).
// 
//
// Example 3: 
//
// 
//Input: 
//
//          1
//         / \
//        3   2 
//       /        
//      5      
//
//Output: 2
//Explanation: The maximum width existing in the second level with the length 2 
//(3,2).
// 
//
// Example 4: 
//
// 
//Input: 
//
//          1
//         / \
//        3   2
//       /     \  
//      5       9 
//     /         \
//    6           7
//Output: 8
//Explanation:The maximum width existing in the fourth level with the length 8 (
//6,null,null,null,null,null,null,7).
//
//
// 
//
// Note: Answer will in the range of 32-bit signed integer. 
// Related Topics Tree


import java.util.*;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
        int result =solution.widthOfBinaryTree(TreeNode.generateFrom(new Object[]{
//                1, 3, 2, 5, null, null, 9
                1, 1, 1, 1, 1, 1, 1, null, null, null, 1, null, null, null, null, 2, 2, 2, 2, 2, 2, 2, null, 2, null, null, 2, null, 2
        }));
        System.out.println(result);
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
        public int widthOfBinaryTree(TreeNode root) {
            return dfs(root, 0, 0, new ArrayList<>(), new ArrayList<>());
        }

        private int dfs(TreeNode root, int level, int order, ArrayList<Integer> start, ArrayList<Integer> end) {
            if (root == null) return 0;
            if (start.size() <= level) {
                start.add(order);
                end.add(order);
            } else {
                end.set(level, order);
            }
            int curr = end.get(level) - start.get(level) + 1;
            int left = dfs(root.left, level + 1, order * 2, start, end);
            int right = dfs(root.right, level + 1, order * 2 + 1, start, end);
            return Math.max(curr, Math.max(left, right));
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
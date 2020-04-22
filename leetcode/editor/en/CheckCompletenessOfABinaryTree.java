package leetcode.editor.en;

//Given a binary tree, determine if it is a complete binary tree.
//
// Definition of a complete binary tree from Wikipedia: 
//In a complete binary tree every level, except possibly the last, is completely
// filled, and all nodes in the last level are as far left as possible. It can hav
//e between 1 and 2h nodes inclusive at the last level h. 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input: [1,2,3,4,5,6]
//Output: true
//Explanation: Every level before the last is full (ie. levels with node-values 
//{1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as 
//possible.
// 
//
// 
// Example 2: 
//
// 
//
// 
//Input: [1,2,3,4,5,null,7]
//Output: false
//Explanation: The node with value 7 isn't as far left as possible.
// 
//
// 
// 
//
// Note: 
//
// 
// The tree will have between 1 and 100 nodes. 
// 
// Related Topics Tree


import java.util.ArrayList;
import java.util.List;

public class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new CheckCompletenessOfABinaryTree().new Solution();
        solution.isCompleteTree(TreeNode.generateFrom(new Object[]{
                1, 2, 3, 4, 5, null, 7
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

        public boolean isCompleteTree(TreeNode root) {

            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            boolean isStopAdded = false;
            for (int i = 0; i < list.size(); i++) {
                TreeNode curr = list.get(i);

                if (curr.left == null && curr.right != null) {
                    return false;
                }

                if (isStopAdded && (curr.left != null || curr.right != null)) {
                    return false;
                }

                if (curr.left != null) {
                    list.add(curr.left);
                }

                if (curr.right != null) {
                    list.add(curr.right);
                }

                if (curr.left == null || curr.right == null) {
                    isStopAdded = true;
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
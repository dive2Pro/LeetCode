package leetcode.editor.en;

//In a binary tree, the root node is at depth 0, and children of each depth k no
//de are at depth k+1. 
//
// Two nodes of a binary tree are cousins if they have the same depth, but have 
//different parents. 
//
// We are given the root of a binary tree with unique values, and the values x a
//nd y of two different nodes in the tree. 
//
// Return true if and only if the nodes corresponding to the values x and y are 
//cousins. 
//
// 
//
// Example 1: 
// 
//
// 
//Input: root = [1,2,3,4], x = 4, y = 3
//Output: false
// 
//
// 
// Example 2: 
// 
//
// 
//Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
//Output: true
// 
//
// 
// Example 3: 
//
// 
//
// 
//Input: root = [1,2,3,null,4], x = 2, y = 3
//Output: false 
//
// 
// 
// 
//
// Note: 
//
// 
// The number of nodes in the tree will be between 2 and 100. 
// Each node has a unique integer value from 1 to 100. 
// 
//
// 
// 
// 
// 
// Related Topics Tree Breadth-first Search


import java.util.Deque;
import java.util.LinkedList;

public class CousinsInBinaryTree{
    public static void main(String[] args) {
         Solution solution = new CousinsInBinaryTree().new Solution();
         solution.isCousins(TreeNode.generateFrom(new Object[]{
            1,2,3,null,null,4,5
         }), 4, 5);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private boolean isUnder(TreeNode node, int x, int y) {
        if(node.left != null && node.right != null) {
            if(node.left.val == x && node.right.val == y) {
                return true;
            } else return node.left.val == y && node.right.val == x;

        }
        return false;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean[] fulled = new boolean[2];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if(node == null) {
                    continue;
                }
                queue.add(node.left);
                queue.add(node.right);
                if(isUnder(node, x, y)) {
                    return false;
                }
                if(node.val == x) {
                    fulled[0] = true;
                } else if(node.val == y) {
                    fulled[1] = true;
                }
            }

            if(fulled[0] && fulled[1]) {
                return true;
            } else if(fulled[0] || fulled[1]) {
                return false;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
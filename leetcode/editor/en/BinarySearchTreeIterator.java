//Implement an iterator over a binary search tree (BST). Your iterator will be i
//nitialized with the root node of a BST. 
//
// Calling next() will return the next smallest number in the BST. 
//
// 
//
// 
// 
//
// Example: 
//
// 
//
// 
//BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // return 3
//iterator.next();    // return 7
//iterator.hasNext(); // return true
//iterator.next();    // return 9
//iterator.hasNext(); // return true
//iterator.next();    // return 15
//iterator.hasNext(); // return true
//iterator.next();    // return 20
//iterator.hasNext(); // return false
// 
//
// 
//
// Note: 
//
// 
// next() and hasNext() should run in average O(1) time and uses O(h) memory, wh
//ere h is the height of the tree. 
// You may assume that next() call will always be valid, that is, there will be 
//at least a next smallest number in the BST when next() is called. 
// 
// Related Topics Stack Tree Design

  
package leetcode.editor.en;

import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTreeIterator{
    public static void main(String[] args) {
//         Solution solution = new BinarySearchTreeIterator().new Solution();
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
class BSTIterator {
    private Deque<TreeNode> deque;
    public BSTIterator(TreeNode root) {
        deque = new LinkedList();
        dfs(root);
    }
    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.left);
        deque.add(node);
        dfs(node.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return deque.remove().val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !deque.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)


}

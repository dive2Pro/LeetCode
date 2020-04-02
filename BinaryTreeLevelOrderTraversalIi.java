//Given a binary tree, return the bottom-up level order traversal of its nodes'
//values. (ie, from left to right, level by level from leaf to root). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its bottom-up level order traversal as: 
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics Tree Breadth-first Search


import java.util.List;

public class BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();      
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}




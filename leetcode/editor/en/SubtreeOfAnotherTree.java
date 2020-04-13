package leetcode.editor.en;

//
//Given two non-empty binary trees s and t, check whether tree t has exactly the
// same structure and node values with a subtree of s. A subtree of s is a tree
// consists of a node in s and all of this node's descendants. The tree s could also
//be considered as a subtree of itself.
// 
//
// Example 1: 
//
//Given tree s:
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//Given tree t:
// 
//   4 
//  / \
// 1   2
// 
//Return true, because t has the same structure and node values with a subtree o
//f s.
// 
//
// Example 2: 
//
//Given tree s:
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//Given tree t:
// 
//   4
//  / \
// 1   2
// 
//Return false.
// Related Topics Tree


public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
        solution.isSubtree(TreeNode.generateFrom(new Object[]{
                1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2
        }), TreeNode.generateFrom(new Object[]{
                1, null, 1, null, 1, null, 1, null, 1, null, 1, 2
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
        private boolean isSub = false;

        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null || t == null) {
                return false;
            }
            dfs(s, t);
            return isSub;
        }

        private void dfs(TreeNode s, TreeNode t) {
            if ( isSub || s == null || t == null) {
                return;
            }

            if (s.val == t.val) {
                isSub = isSameTree(s, t);
            }

            dfs(s.left, t);
            dfs(s.right, t);
        }

        private boolean isSameTree(TreeNode s, TreeNode t) {

            if (s == null && t == null) {
                return true;
            } else if (s == null || t == null) {
                return false;
            }

            if (s.val == t.val) {
                return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
            } else {
                return false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
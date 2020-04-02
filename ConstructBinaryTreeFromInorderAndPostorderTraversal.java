
//Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics Array Tree Depth-first Search


public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder.length == 0 || postorder.length == 0 ) {
                return null;
            }
            int rootVal = inorder[0];
            int postOrderFence = 0;
            for(int i = 0 ; i < postorder.length ;i ++) {
                if(postorder[i] == rootVal) {
                    postOrderFence = i;
                }
            }

//            int[] leftPost

            TreeNode root = new TreeNode(rootVal);



            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}




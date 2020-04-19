//Return any binary tree that matches the given preorder and postorder traversal
//s. 
//
// Values in the traversals pre and post are distinct positive integers. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//Output: [1,2,3,4,5,6,7]
// 
//
// 
//
// Note: 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] and post[] are both permutations of 1, 2, ..., pre.length. 
// It is guaranteed an answer exists. If there exists multiple answers, you can 
//return any of them. 
// 
// 
// Related Topics Tree


package leetcode.editor.en;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
        TreeNode node = solution.constructFromPrePost(new int[]{
                1, 2, 4, 5, 3, 6, 7
        }, new int[]{
                4, 5, 2, 6, 7, 3, 1
        });

        System.out.println(node);
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
        public TreeNode constructFromPrePost(int[] pre, int[] post) {

            return buildTree(pre, 0, pre.length - 1, post, 0, post.length - 1);
        }

        TreeNode buildTree(int[] pre, int preLoIndex, int preHiIndex, int[] post,
                           int postLo, int postHi) {
            if (preLoIndex > preHiIndex || postLo > postHi) return null;
            else if(preLoIndex == preHiIndex) return new TreeNode(pre[preLoIndex]);

            TreeNode root = new TreeNode(pre[preLoIndex]);

            int preLo = pre[preLoIndex + 1];
            int i;
            for (i = postHi; i >= postLo; i--) {
                if (preLo == post[i]) {
                    break;
                }
            }
            int diff = i - postLo;
            root.left = buildTree(pre, preLoIndex + 1, preLoIndex + 1 + diff,
                    post, postLo, i);
            root.right = buildTree(pre, preLoIndex + 1 + diff + 1, preHiIndex,
                    post, i + 1, postHi);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

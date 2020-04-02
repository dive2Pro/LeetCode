//Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search


import java.util.Arrays;
import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        TreeNode node = solution.buildTree(new int[]{ 3, 9,4, 20, 15, 7}, new int[] {4, 9,3,15, 20, 7});

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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int i = 0; i < inorder.length; i ++) {
                hashMap.put(inorder[i], i);
            }
            return buildTree(preorder, 0, hashMap, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int inIdx, HashMap<Integer, Integer> inMap, int inLeft, int inRight ) {
            if(inLeft > inRight) {
                return null;
            }

            int rootVal = preorder[inIdx];
            int inIndexIndex = inMap.get(rootVal);
            TreeNode node = new TreeNode(rootVal);

            node.left = buildTree(preorder, inIdx + 1, inMap, inLeft, inIndexIndex - 1);
            node.right = buildTree(preorder, inIndexIndex + 1 + inIdx - inLeft, inMap, inIndexIndex + 1, inRight);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}




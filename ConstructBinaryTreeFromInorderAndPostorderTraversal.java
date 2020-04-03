
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


import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        TreeNode node = solution.buildTree(
                new int[]{4, 9, 3, 15, 20, 7},
                new int[]{4, 9, 15, 7, 20, 3}
        );

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
            HashMap<Integer, Integer> inMap = new HashMap<>();
            for (int i = 0; i < postorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            return buildTree(postorder, 0, postorder.length - 1, inMap, 0, postorder.length - 1);
        }


        private TreeNode buildTree(int[] postorder, int inorderLeft, int inorderRight, HashMap<Integer, Integer> inorderMap, int inLeft, int inRight) {
            if (inLeft > inRight) {
                return null;
            }

            int rootVal = postorder[inRight];

            int inorderIdx = inorderMap.get(rootVal);
            int leftSize = inorderIdx - inorderLeft;
            int rightSize = inorderRight - inorderIdx;


            if (inLeft == inRight) {
                return new TreeNode(rootVal);
            }

            TreeNode root = new TreeNode(rootVal);
            root.left = leftSize == 0 ? null : buildTree(postorder,
                    inorderLeft, inorderIdx - 1, inorderMap, inLeft, inLeft + leftSize - 1);
            root.right = rightSize == 0 ? null : buildTree(postorder,
                    inorderIdx + 1, inorderRight, inorderMap, inLeft + leftSize, rightSize + inLeft + leftSize - 1);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}




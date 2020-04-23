package leetcode.editor.en;

//Return the root node of a binary search tree that matches the given preorder t
//raversal. 
//
// (Recall that a binary search tree is a binary tree where for every node, any 
//descendant of node.left has a value < node.val, and any descendant of node.right
// has a value > node.val. Also recall that a preorder traversal displays the valu
//e of the node first, then traverses node.left, then traverses node.right.) 
//
// 
//
// Example 1: 
//
// 
//Input: [8,5,1,7,10,12]
//Output: [8,5,10,1,7,null,12]
//
// 
//
// 
//
// Note: 
//
// 
// 1 <= preorder.length <= 100 
// The values of preorder are distinct. 
// 
// Related Topics Tree


public class ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinarySearchTreeFromPreorderTraversal().new Solution();
        TreeNode treeNode = solution.bstFromPreorder(new int[]{
                8, 5, 1, 7, 10, 12
        });
        System.out.println(treeNode);
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
        public TreeNode bstFromPreorder(int[] preorder) {
            return buildTree(null, preorder, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode buildTree(TreeNode root, int[] preorder, int[] index, int minValue, int maxValue) {
            if (index[0] == preorder.length) return null;
            if (minValue >= maxValue) return null;
            if (preorder[index[0]] < minValue || preorder[index[0]] > maxValue) {
                return null;
            }
            if (root == null) {
                root = new TreeNode(preorder[index[0]++]);
            }
            root.left = buildTree(root.left, preorder, index, minValue, root.val);
            root.right = buildTree(root.right, preorder, index, root.val, maxValue);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
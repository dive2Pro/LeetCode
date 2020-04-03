//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes 
//in the tree. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p and
// q as descendants (where we allow a node to be a descendant of itself).” 
//
// Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
// 
//
// Example 2: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant o
//f itself according to the LCA definition.
// 
//
// 
//
// Note: 
//
// 
// All of the nodes' values will be unique. 
// p and q are different and both values will exist in the binary tree. 
// 
// Related Topics Tree

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        TreeNode left2 =
                new TreeNode(2);
        TreeNode left4 =
                new TreeNode(4);
        left.right = left2;
        left2.right = left4;
        root.left = left;
        root.right = right;
        solution.lowestCommonAncestor(root, left, left4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */


    class Solution {

        private TreeNode result = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            find(root, p, q);

            return result;
        }

        public TreeNode find(TreeNode x, TreeNode p,
                             TreeNode q) {

            if (result != null) {
                return null;
            }

            if (x == null) {
                return null;
            }


            TreeNode left = find(x.left, p, q);
            TreeNode right = find(x.right, p, q);

            boolean isThis = x.val == p.val || x.val == q.val;

            if (left != null && right != null) {
                result = x;
                return result;
            } else if (left != null) {
                if (isThis) {
                    result = x;
                    return x;
                }
                return left;
            } else if (right != null) {
                if (isThis) {
                    result = x;
                    return x;
                }
                return right;
            }
            if (isThis) {
                return x;
            }

            return null;
        }
    }

}




//Given a binary tree rooted at root, the depth of each node is the shortest dis
//tance to the root. 
//
// A node is deepest if it has the largest depth possible among any node in the 
//entire tree. 
//
// The subtree of a node is that node, plus the set of all descendants of that n
//ode. 
//
// Return the node with the largest depth such that it contains all the deepest 
//nodes in its subtree. 
//
// 
//
// Example 1: 
//
// 
//Input: [3,5,1,6,2,0,8,null,null,7,4]
//Output: [2,7,4]
//Explanation:
//
//
//
//We return the node with value 2, colored in yellow in the diagram.
//The nodes colored in blue are the deepest nodes of the tree.
//The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the 
//given tree.
//The output "[2, 7, 4]" is a serialization of the subtree rooted at the node wi
//th value 2.
//Both the input and output have TreeNode type.
// 
//
// 
//
// Note: 
//
// 
// The number of nodes in the tree will be between 1 and 500. 
// The values of each node are unique. 
// 
// Related Topics Tree


package leetcode.editor.en;

public class SmallestSubtreeWithAllTheDeepestNodes {
    public static void main(String[] args) {
        Solution solution = new SmallestSubtreeWithAllTheDeepestNodes().new Solution();

        TreeNode node =
                solution.subtreeWithAllDeepest(TreeNode.generateFrom(new Object[]{
                3, 5, 1, 6, 2, 0, 8, null, null, 7, 4
        }));
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
        public TreeNode subtreeWithAllDeepest(TreeNode root) {

            int height = getHeight(root);
            return dfs(root, 1, height);
        }

        int getHeight(TreeNode node) {
            if (node == null) return 0;
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }


        private TreeNode dfs(TreeNode node, int level, int height) {
            if (node == null) {
                return null;
            }
            if (level == height) {
                return node;
            }

            TreeNode left = dfs(node.left, level + 1, height);
            TreeNode right = dfs(node.right, level + 1, height);

            if (left == null && right == null) {
                return null;
            } else if (left != null && right != null) {
                return node;
            } else if (right != null) {
                return right;
            } else {
                return left;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

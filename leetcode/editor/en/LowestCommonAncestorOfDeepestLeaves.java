package leetcode.editor.en;

//Given a rooted binary tree, return the lowest common ancestor of its deepest l
//eaves. 
//
// Recall that: 
//
// 
// The node of a binary tree is a leaf if and only if it has no children 
// The depth of the root of the tree is 0, and if the depth of a node is d, the 
//depth of each of its children is d+1. 
// The lowest common ancestor of a set S of nodes is the node A with the largest
// depth such that every node in S is in the subtree with root A. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3]
//Output: [1,2,3]
//Explanation: 
//The deepest leaves are the nodes with values 2 and 3.
//The lowest common ancestor of these leaves is the node with value 1.
//The answer returned is a TreeNode object (not an array) with serialization "[1
//,2,3]".
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3,4]
//Output: [4]
// 
//
// Example 3: 
//
// 
//Input: root = [1,2,3,4,5]
//Output: [2,4,5]
// 
//
// 
// Constraints: 
//
// 
// The given tree will have between 1 and 1000 nodes. 
// Each node of the tree will have a distinct value between 1 and 1000. 
// 
// Related Topics Tree Depth-first Search


public class LowestCommonAncestorOfDeepestLeaves {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfDeepestLeaves().new Solution();
        solution.lcaDeepestLeaves(TreeNode.generateFrom(new Object[]{
            1, 2, 3, 4, 5, 6
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

        class Pair {
            Integer key;
            TreeNode node;

            public Pair(Integer key, TreeNode node) {
                this.key = key;
                this.node = node;
            }
        }

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            Pair pair = dfs(root, 0);
            return pair.node;
        }

        Pair dfs(TreeNode node, int level) {
            if (node == null) {
                return new Pair(level, null);
            }
            Pair leftDeep = dfs(node.left, level + 1);
            Pair rightDeep = dfs(node.right, level + 1);

            if (leftDeep.key > rightDeep.key) {
                return leftDeep;
            } else if (leftDeep.key.equals(rightDeep.key)) {
                return new Pair(leftDeep.key, node);
            } else {
                return rightDeep;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
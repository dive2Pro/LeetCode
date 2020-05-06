package leetcode.editor.en;

//A full binary tree is a binary tree where each node has exactly 0 or 2 children.
//
// Return a list of all possible full binary trees with N nodes. Each element of
// the answer is the root node of one possible tree. 
//
// Each node of each tree in the answer must have node.val = 0. 
//
// You may return the final list of trees in any order. 
//
// 
//
// Example 1: 
//
// 
// Input: 7
// Output: [
//          [0,0,0,null,null,0,0,null,null,0,0],
//          [0,0,0,null,null,0,0,0,0],
//          [0,0,0,0,0,0,0],
//          [0,0,0,0,0,null,null,null,null,0,0],
//          [0,0,0,0,0,null,null,0,0]
//         ]
// Explanation:
//
// 
//
// 
//
// Note: 
//
// 
// 1 <= N <= 20
// 
// Related Topics Tree Recursion


import java.util.ArrayList;
import java.util.List;

/**
 * 1. 在二叉树构建完毕时添加到 list
 * 2. 每个分叉, 要重新构建新的树, 下层要添加到新树上面
 */
public class AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new AllPossibleFullBinaryTrees().new Solution();
        solution.allPossibleFBT(7);
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
        public List<TreeNode> allPossibleFBT(int N) {
            List<TreeNode> list = new ArrayList<>();
            if (N == 0) return list;

            TreeNode root = new TreeNode(0);
//            N--;

            buildFullTree(root, list, N, new TreeNode[]{ null });

            return list;
        }

        TreeNode copyFrom(TreeNode node) {
            if (node == null) return null;

            TreeNode root = new TreeNode(node.val);
            root.left = copyFrom(node.left);
            root.right = copyFrom(node.right);
            return root;
        }

        TreeNode newOne() {
            return new TreeNode(0);
        }

        private TreeNode buildFullTree(TreeNode root, List<TreeNode> list, int n, TreeNode[] rootTree) {
            if (n < 0) return null;
            if (root == null) {
                root = newOne();
            }
            if (rootTree[0] == null) {
                rootTree[0] = root;
            }

            n--;

            System.out.println(n);
            if( n > 0) {

            }
            for (int i = 1; i < n; i += 2) {
                TreeNode nextRoot = root;
                if (i == 1 || n - i == 1) {
                    nextRoot = copyFrom(root);
                }
                nextRoot.left = buildFullTree(nextRoot.left, list, i, rootTree);
                nextRoot.right = buildFullTree(nextRoot.right, list, n - i, rootTree);
            }

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
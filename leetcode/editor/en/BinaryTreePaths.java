package leetcode.editor.en;

//Given a binary tree, return all root-to-leaf paths.
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
// Related Topics Tree Depth-first Search


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rootRight = new TreeNode(3);
        rootLeft.right = leftRight;
        root.right = rootRight;
        root.left = rootLeft;
        solution.binaryTreePaths(root);
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            dfs(root, list, sb);
            return list;
        }

        private void dfs(TreeNode node, List<String> list, StringBuilder path) {
            if (node == null) {
                return;
            }

            int len = path.length();

            path.append(node.val);


            if (node.left == null && node.right == null) {
                list.add(path.toString());
            } else {
                path.append("->");
                dfs(node.left, list, path);
                dfs(node.right, list, path);
            }
            path.setLength(len); // 重置长度

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
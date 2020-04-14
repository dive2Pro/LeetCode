package leetcode.editor.en;

//Given a binary tree, imagine yourself standing on the right side of it, return
// the values of the nodes you can see ordered from top to bottom. 
//
// Example: 
//
// 
//Input: [1,2,3,null,5,null,4]
//Output: [1, 3, 4]
//Explanation:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// Related Topics Tree Depth-first Search Breadth-first Search


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        solution.rightSideView(TreeNode.generateFrom(new Object[]{
                1, 2, 3, null, 5, null, 4
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
        public List<Integer> rightSideView(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            dfs(root, list, 0);
            return list;
        }

        private void dfs(TreeNode root, ArrayList<Integer> list, int level) {
            if (root == null) return;
            if (list.size() <= level) {
                list.add(root.val);
            } else {
                list.set(level, root.val);
            }

            dfs(root.left, list, level + 1);
            dfs(root.right, list, level + 1);

        }

        public List<Integer> rightSideView2(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            ArrayList<Integer> list = new ArrayList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                list.add(
                        deque.getLast().val
                );
                while (size-- > 0) {
                    TreeNode node = deque.pop();
                    if (node.left != null) {
                        deque.add(node.left);
                    }
                    if (node.right != null) {
                        deque.add(node.right);
                    }
                }
            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
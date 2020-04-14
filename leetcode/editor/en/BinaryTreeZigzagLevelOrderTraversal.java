package leetcode.editor.en;

//Given a binary tree, return the zigzag level order traversal of its nodes' val
//ues. (ie, from left to right, then right to left for the next level and alternat
//e between). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its zigzag level order traversal as: 
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics Stack Tree Breadth-first Search


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        solution.zigzagLevelOrder(TreeNode.generateFrom(new Object[]{
                3, 9, 20, null, null, 15, 7
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();

            traversal(list, root, 0);

            return list;
        }

        private void traversal(List<List<Integer>> list, TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (list.size() <= level) {
                list.add(new ArrayList<>());
            }

            if (level % 2 == 0) {
                list.get(level).add(root.val);
            } else {
                list.get(level).add(0, root.val);
            }

            traversal(list, root.left, level + 1);
            traversal(list, root.right, level + 1);

        }

        public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            int order = 1;
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> numbers = new ArrayList<>();

                while (size-- > 0) {
                    TreeNode node = deque.pop();
                    if (node == null) {
                        continue;
                    }
                    deque.add(node.left);
                    deque.add(node.right);

                    if (order == 1) {
                        numbers.add(node.val);
                    } else {
                        numbers.add(0, node.val);
                    }
                }
                order *= -1;
                if (numbers.size() > 0)
                    list.add(numbers);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
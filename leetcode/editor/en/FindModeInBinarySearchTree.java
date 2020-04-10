package leetcode.editor.en;

//Given a binary search tree (BST) with duplicates, find all the mode(s) (the mo
//st frequently occurred element) in the given BST. 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than or equal t
//o the node's key. 
// The right subtree of a node contains only nodes with keys greater than or equ
//al to the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// For example: 
//Given BST [1,null,2,2], 
//
// 
//   1
//    \
//     2
//    /
//   2
// 
//
// 
//
// return [2]. 
//
// Note: If a tree has more than one mode, you can return them in any order. 
//
// Follow up: Could you do that without using any extra space? (Assume that the 
//implicit stack space incurred due to recursion does not count). 
// Related Topics Tree


import java.util.*;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
        TreeNode root = TreeNode.generateFrom(new Object[]{6, 2, 8, 0, 4, 7, 9, null, null, 2, 6});
        solution.findMode(root);
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
        public int[] findMode(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }
            HashMap<Integer, Integer> sums = new HashMap<>();

            HashMap<Integer, List<Integer>> countMap = new HashMap<>();


            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            int max = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                dfs(node, sums, queue, 0);

                if (sums.get(node.val) > max) {
                    max = sums.get(node.val);
                }

            }
            Iterator<Map.Entry<Integer, Integer>> iterator = sums.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() == max) {
                    list.add(entry.getKey());
                }
            }
            return list.stream().mapToInt(i -> i).toArray();
        }

        private int dfs(TreeNode node, HashMap<Integer, Integer> sums, Queue<TreeNode> queue, int sum) {
            if (node == null) {
                return 0;
            }

            sum++;
            sums.put(node.val, sums.getOrDefault(node.val, 0) + 1);

            if (node.left != null) {
                if (node.left.val == node.val) {
                    sum += dfs(node.left, sums, queue, 0);
                } else {
                    queue.add(node.left);
                }
            }

            if (node.right != null) {
                if (node.right.val == node.val) {
                    sum += dfs(node.right, sums, queue, 0);
                } else {
                    queue.add(node.right);
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
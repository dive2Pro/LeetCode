package leetcode.editor.en;

//Given a binary tree, return the bottom-up level order traversal of its nodes'
//values. (ie, from left to right, level by level from leaf to root). 
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
//return its bottom-up level order traversal as: 
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics Tree Breadth-first Search


import java.util.*;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if (root == null) {
                return list;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> childQueue = new LinkedList<>();
            list.add(new ArrayList<>());
//            queue.add(root);
            Map<Integer, List<Integer>> map = new HashMap<>();


            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();

                list.get(list.size() - 1).add(node.val);

                if (node.left != null) {
                    childQueue.add(node.left);
                }

                if (node.right != null) {
                    childQueue.add(node.right);
                }

                if (queue.isEmpty() && !childQueue.isEmpty()) {
                    list.add(new ArrayList<>());
                    queue.addAll(childQueue);
                    childQueue.clear();
                }
            }
//            bfs(map, root, 0);
//            list.addAll(map.values());
//            Collections.reverse(list);
            dfs(list, root, 0);
            return bfs(root);
        }

        private List<List<Integer>> bfs(TreeNode node) {
            List<List<Integer>> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList();
            queue.add(node);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> integers = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode n = queue.poll();
                    if (n == null) {
                        continue;
                    }
                    integers.add(n.val);
                    if (n.left != null) {
                        queue.add(n.left);
                    }
                    if (n.right != null) {
                        queue.add(n.right);
                    }
                }
                list.add(0, integers);
            }
            return list;
        }

        private void dfs(List<List<Integer>> list, TreeNode node, int level) {
            if (node == null) {
                return;
            }

            if (list.size() == level) {
                list.add(list.size(), new ArrayList<>());
            }
            dfs(list, node.left, level + 1);
            dfs(list, node.right, level + 1);
            list.get(level).add(node.val);
        }

        private void bfs(Map<Integer, List<Integer>> map, TreeNode node, int level) {
            if (node == null) {
                return;
            }
            if (map.get(level) == null) {
                map.put(level, new ArrayList<>());
            }

            bfs(map, node.left, level + 1);
            bfs(map, node.right, level + 1);
            map.get(level).add(node.val);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
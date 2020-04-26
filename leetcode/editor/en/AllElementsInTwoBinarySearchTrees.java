package leetcode.editor.en;

//Given two binary search trees root1 and root2.
//
// Return a list containing all the integers from both trees sorted in ascending
// order. 
//
// 
// Example 1: 
//
// 
//Input: root1 = [2,1,4], root2 = [1,0,3]
//Output: [0,1,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
//Output: [-10,0,0,1,2,5,7,10]
// 
//
// Example 3: 
//
// 
//Input: root1 = [], root2 = [5,1,7,0,2]
//Output: [0,1,2,5,7]
// 
//
// Example 4: 
//
// 
//Input: root1 = [0,-10,10], root2 = []
//Output: [-10,0,10]
// 
//
// Example 5: 
//
// 
//Input: root1 = [1,null,8], root2 = [8,1]
//Output: [1,1,8,8]
// 
//
// 
// Constraints: 
//
// 
// Each tree has at most 5000 nodes. 
// Each node's value is between [-10^5, 10^5]. 
// 
// Related Topics Sort Tree


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new AllElementsInTwoBinarySearchTrees().new Solution();
        solution.getAllElements(TreeNode.generateFrom(new Object[]{
                2, 1, 4
        }), TreeNode.generateFrom(new Object[]{
                1, 0, 3
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
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            Deque<Integer> list1 = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            dfs(root1, list1);
            insertIn(root2, list1, list);
            list.addAll(list1);
            return list;
        }

        private void dfs(TreeNode root, Deque<Integer> list) {
            if (root == null) return;
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }

        private void insertIn(TreeNode root, Deque<Integer> list, List<Integer> result) {
            if (root == null) return;
            insertIn(root.left, list, result);
            while (list.peek() != null && list.peek() <= root.val) {
                result.add(list.pop());
            }
            result.add(root.val);
            insertIn(root.right, list, result);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
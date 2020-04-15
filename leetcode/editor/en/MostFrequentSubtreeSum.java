package leetcode.editor.en;

//
//Given the root of a tree, you are asked to find the most frequent subtree sum.
// The subtree sum of a node is defined as the sum of all the node values formed b
//y the subtree rooted at that node (including the node itself). So what is the mo
//st frequent subtree sum value? If there is a tie, return all the values with the
// highest frequency in any order.
// 
//
// Examples 1 
//Input:
// 
//  5
// /  \
//2   -3
// 
//return [2, -3, 4], since all the values happen only once, return all of them i
//n any order.
// 
//
// Examples 2 
//Input:
// 
//  5
// /  \
//2   -5
// 
//return [2], since 2 happens twice, however -5 only occur once.
// 
//
// Note:
//You may assume the sum of values in any subtree is in the range of 32-bit sign
//ed integer.
// Related Topics Hash Table Tree


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new MostFrequentSubtreeSum().new Solution();
        solution.findFrequentTreeSum(TreeNode.generateFrom(new Object[]{
//                3, 1, 6, null, 2, 5, 7, null, null, 4
                5, 2, -3
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
        int max = Integer.MIN_VALUE;

        public int[] findFrequentTreeSum(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> count = new HashMap<>();
            dfs(list, root, count);
            int[] is = new int[list.size()];
            for (int i = 0; i < is.length; i++) {
                is[i] = list.get(i);
            }

            return is;
        }

        private int dfs(List<Integer> list, TreeNode root, Map<Integer, Integer> count) {
            if (root == null) return 0;
            int left = dfs(list, root.left, count);
            int right = dfs(list, root.right, count);
            int result = left + right + root.val;

            int nextCount = count.getOrDefault(result, 0) + 1;
            if (nextCount > max) {
                list.clear();
                list.add(result);
                max = nextCount;
            } else if (nextCount == max) {
                list.add(result);
            }
            count.put(result, nextCount);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
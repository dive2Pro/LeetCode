package leetcode.editor.en;

//You need to find the largest value in each row of a binary tree.
//
// Example: 
// 
//Input: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//Output: [1, 3, 9]
// 
// 
// Related Topics Tree Depth-first Search Breadth-first Search


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                int largest = Integer.MIN_VALUE;
                while (size-- > 0) {
                    TreeNode node = deque.pop();
                    if (node.val > largest) {
                        largest = node.val;
                    }

                    if (node.left != null)
                        deque.add(node.left);
                    if (node.right != null)
                        deque.add(node.right);
                }
                list.add(largest);
            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
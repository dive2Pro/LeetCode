package leetcode.editor.en;

//Given the root of a binary tree, each node has a value from 0 to 25 representi
//ng the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 
//'b', and so on. 
//
// Find the lexicographically smallest string that starts at a leaf of this tree
// and ends at the root. 
//
// (As a reminder, any shorter prefix of a string is lexicographically smaller: 
//for example, "ab" is lexicographically smaller than "aba". A leaf of a node is a
// node that has no children.) 
//
// 
// 
// 
//
// 
// 
// 
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: [0,1,2,3,4,3,4]
//Output: "dba"
// 
//
// 
// Example 2: 
//
// 
//
// 
//Input: [25,1,3,1,3,0,2]
//Output: "adz"
// 
//
// 
// Example 3: 
//
// 
//
// 
//Input: [2,2,1,null,1,0,null,0]
//Output: "abc"
// 
//
// 
//
// Note: 
//
// 
// The number of nodes in the given tree will be between 1 and 8500. 
// Each node in the tree will have a value between 0 and 25. 
// 
// 
// 
// Related Topics Tree Depth-first Search


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestStringStartingFromLeaf {
    public static void main(String[] args) {
        Solution solution = new SmallestStringStartingFromLeaf().new Solution();
        solution.smallestFromLeaf(TreeNode.generateFrom(new Object[]{
//                0, 1, 2, 3, 4, 3, 4
                2, 2, 1, null, 1, 0, null, 0
        }));

        solution.smallestFromLeaf(TreeNode.generateFrom(new Object[]{
//                4, 0, 1, 1
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
        List<Integer> smallest;

        public String smallestFromLeaf(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            smallest = new ArrayList<>();
            dfs(root, list);
            StringBuilder sb = new StringBuilder();
            for (int i = smallest.size() - 1; i >= 0; i--) {
                char c = (char) (smallest.get(i) + 97);
                sb.append(c);
            }
            return sb.toString();
        }

        void copyTo(List<Integer> source, List<Integer> dest) {
            dest.clear();
            dest.addAll(source);
        }

        private void dfs(TreeNode root, List<Integer> list) {
            if (root == null) return;
            int index = list.size();
            list.add(root.val);
            dfs(root.left, list);
            dfs(root.right, list);
            if (root.left == null && root.right == null) {
                if (compare(list, smallest)) {
                    copyTo(list, smallest);
                }
            }
            list.remove(index);
        }

        private boolean compare(List<Integer> list, List<Integer> smallest) {

            if (smallest.size() < 1) {
                return true;
            }

            int listSize = list.size() - 1;
            int smallSize = smallest.size() - 1;
            while (listSize > -1 && smallSize > -1) {
                int l = list.get(listSize);
                int r = smallest.get(smallSize);

                listSize--;
                smallSize--;

                if (l < r) {
                    return true;
                } else if (l > r) {
                    return false;
                }
            }

            return listSize <= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
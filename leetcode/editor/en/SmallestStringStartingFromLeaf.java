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


import java.util.*;

public class SmallestStringStartingFromLeaf {
    public static void main(String[] args) {
        Solution solution = new SmallestStringStartingFromLeaf().new Solution();
        solution.smallestFromLeaf(TreeNode.generateFrom(new Object[]{
//                0, 1, 2, 3, 4, 3, 4
//                2, 2, 1, null, 1, 0, null, 0
                25, 1, null, 0, 0, 1, null, null, null, 0
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
        String smallStr;

        public String smallestFromLeaf(TreeNode root) {
            smallStr = "";
            dfs(root, new StringBuilder());
            return smallStr;
        }

        private void dfs(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            int index = sb.length();
            sb.append((char)(root.val + 'a'));
            dfs(root.left, sb);
            dfs(root.right, sb);
            if (root.left == null && root.right == null) {
                String str = sb.reverse().toString();
                sb.reverse();
                if (smallStr.equals("")) {
                    smallStr = str;
                } else if (smallStr.compareTo(str) > 0) {
                    smallStr = str;
                }
            }
            sb.setLength(index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
package leetcode.editor.en;

//Print a binary tree in an m*n 2D string array following these rules:
//
// 
// The row number m should be equal to the height of the given binary tree. 
// The column number n should always be an odd number. 
// The root node's value (in string format) should be put in the exactly middle 
//of the first row it can be put. The column and the row where the root node belon
//gs will separate the rest space into two parts (left-bottom part and right-botto
//m part). You should print the left subtree in the left-bottom part and print the
// right subtree in the right-bottom part. The left-bottom part and the right-bott
//om part should have the same size. Even if one subtree is none while the other i
//s not, you don't need to print anything for the none subtree but still need to l
//eave the space as large as that for the other subtree. However, if two subtrees 
//are none, then you don't need to leave space for both of them. 
// Each unused space should contain an empty string "". 
// Print the subtrees following the same rules. 
// 
//
// Example 1: 
// 
//Input:
//     1
//    /
//   2
//Output:
//[["", "1", ""],
// ["2", "", ""]]
// 
// 
//
//
// Example 2: 
// 
//Input:
//     1
//    / \
//   2   3
//    \
//     4
//Output:
//[["", "", "", "1", "", "", ""],
// ["", "2", "", "", "", "3", ""],
// ["", "", "4", "", "", "", ""]]
// 
// 
//
// Example 3: 
// 
//Input:
//      1
//     / \
//    2   5
//   / 
//  3 
// / 
//4 
//Output:
//
//[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
// ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
// ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
// ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
// 
// 
//
// Note:
//The height of binary tree is in the range of [1, 10].
// Related Topics Tree


import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    public static void main(String[] args) {
        Solution solution = new PrintBinaryTree().new Solution();
        solution.printTree(TreeNode.generateFrom(new Object[]{1, 2, 5, 3, null, null, null, 4}));
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
        public List<List<String>> printTree(TreeNode root) {
            int height = getHeight(root);
            List<List<String>> stringList = new ArrayList<>();
            int levelLength = 1;
            for (int i = 1; i < height; i++) {
                levelLength = levelLength * 2 + 1;
            }
            for (int i = 1; i <= height; i++) {
                List<String> listItem = new ArrayList<>();
                stringList.add(listItem);
                for (int j = 0; j < levelLength; j++) {
                    listItem.add("");
                }
            }
            dfs(root, stringList, 0, 0, stringList.get(0).size());
            return stringList;
        }

        private void dfs(TreeNode root, List<List<String>> stringList, int level, int lo, int hi) {
            if (root == null) return;
            if (lo > hi) return;
            List<String> currList = stringList.get(level);
            int mid = (lo + hi) / 2;
            currList.set(mid, String.valueOf(root.val));

            dfs(root.left, stringList, level + 1, lo, mid);
            dfs(root.right, stringList, level + 1, mid + 1, hi);
        }

        private int getHeight(TreeNode root) {
            if (root == null) return 0;
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
package leetcode.editor.en;

//You need to construct a string consists of parenthesis and integers from a
// binary tree with the preorder traversing way.
//
// The null node needs to be represented by empty parenthesis pair "()". And you
// need to omit all the empty parenthesis pairs that don't affect the one-to-one
// mapping relationship between the string and the original binary tree.
//
// Example 1: 
// 
//Input: Binary tree: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//Output: "1(2(4))(3)"
// Explanation: Originally it needs to be "1(2(4)())(3()())", but you need to
// omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)".
// 
// 
//
// Example 2: 
// 
//Input: Binary tree: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \  
//      4 
//
//Output: "1(2()(4))(3)"
// Explanation: Almost the same as the first example, except we can't omit the
// first parenthesis pair to break the one-to-one mapping relationship between the
// input and the output.
// 
// Related Topics String Tree


public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        Solution solution = new ConstructStringFromBinaryTree().new Solution();
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
        public String tree2str(TreeNode t) {
            if( t == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            dfs(t, sb);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        private void dfs(TreeNode t, StringBuilder sb) {
            if (t == null) {
                return;
            }
            sb.append("(");
            sb.append(t.val);
            if (t.left == null && t.right == null) {
            } else if (t.left == null) {
                sb.append("()");
                dfs(t.right, sb);
            } else {
                dfs(t.left, sb);
                dfs(t.right, sb);
            }

            sb.append(")");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
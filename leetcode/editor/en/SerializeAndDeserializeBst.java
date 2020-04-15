package leetcode.editor.en;

//Serialization is the process of converting a data structure or object into a
// sequence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary search tree. There 
//is no restriction on how your serialization/deserialization algorithm should wor
//k. You just need to ensure that a binary search tree can be serialized to a stri
//ng and this string can be deserialized to the original tree structure. 
//
// The encoded string should be as compact as possible. 
//
// Note: Do not use class member/global/static variables to store states. Your s
//erialize and deserialize algorithms should be stateless. 
// Related Topics Tree


import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeBst {
    public static void main(String[] args) {
        Codec codec = new SerializeAndDeserializeBst().new Codec();
        String s = codec.serialize(TreeNode.generateFrom(new Object[]{
                3, 2, 6, null, null, 4, null, null, 5
        }));

        TreeNode node = codec.deserialize("");
        System.out.println(node);

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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            preOrderDfs(root, sb);
            return sb.toString();
        }

        private void preOrderDfs(TreeNode root, StringBuilder sb) {
            if (sb.length() > 0) {
//                sb.append(",");
            }

            if (root == null) {
//                sb.append("X");
                return;
            }

            sb.append(root.val);
            sb.append(",");
            preOrderDfs(root.left, sb);
            preOrderDfs(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("")) return null;
            return dfs(data.split(","), new int[]{0}, Integer.MAX_VALUE);
        }

        private TreeNode dfs(String[] ss, int[] i, int max) {
            if (ss.length == i[0]) return null;
            int val = Integer.parseInt(ss[i[0]]);
            if (val > max) return null;
            i[0]++;
            TreeNode res = new TreeNode(val);
            res.left = dfs(ss, i, val);
            res.right = dfs(ss, i, max);
            return res;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)


}
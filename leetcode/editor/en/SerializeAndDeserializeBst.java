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
        String s = codec.serialize(TreeNode.generateFrom(new Object[]{1, 2, 3, null, 4, 5, 6, null, null, 6}));

        TreeNode node = codec.deserialize(s);
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
                sb.append(",");
            }

            if (root == null) {
                sb.append("X");
                return;
            }

            sb.append(root.val);
            preOrderDfs(root.left, sb);
            preOrderDfs(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strings = data.split(",");
            TreeNode root = null;
            if (data.equals("")) {
                return null;
            }
            int[] index = new int[]{0};
            root = buildTreeInPreOrder(root, strings, index);
            return root;
        }

        private TreeNode buildTreeInPreOrder(TreeNode root, String[] strings, int[] i) {
            String s = strings[i[0]];
            i[0]++;
            if (s.equals("X")) {
                return null;
            }
            int val = Integer.parseInt(s);

            if (root == null) {
                root = new TreeNode(val);
            }
            root.left = buildTreeInPreOrder(root.left, strings, i);
            root.right = buildTreeInPreOrder(root.right, strings, i);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)


}
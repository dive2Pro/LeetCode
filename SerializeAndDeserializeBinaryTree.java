//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure. 
//
// Example: 
//
// 
//You may serialize the following tree:
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//as "[1,2,3,null,null,4,5]"
// 
//
// Clarification: The above format is the same as how LeetCode serializes a bina
//ry tree. You do not necessarily need to follow this format, so please be creativ
//e and come up with different approaches yourself. 
//
// Note: Do not use class member/global/static variables to store states. Your s
//erialize and deserialize algorithms should be stateless. 
// Related Topics Tree Design


import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        TreeNode left2 =
                new TreeNode(2);
        TreeNode left4 =
                new TreeNode(4);
        left.right = left2;
        left2.right = left4;
        root.left = left;
        root.right = right;
        Codec c = new  SerializeAndDeserializeBinaryTree().new Codec();
        String s = c.serialize(root);
        System.out.println(s);
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

        private void putToQueue(TreeNode n, Queue<TreeNode> queue) {
            if(n == null) {
                queue.add(null);
                queue.add(null);
            } else {

                queue.add(n.left);
                queue.add(n.right);
            }
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> queueChild = new LinkedList<>();
            stringBuilder.append("[");
            queue.add(root);
            while (!queue.isEmpty()) {
                StringBuilder sb = serialize(queue, queueChild);
                if(sb.length() > 0) {
                    stringBuilder.append("[");
                    stringBuilder.append(sb);
                    stringBuilder.append("]");
                }
                queue.addAll(queueChild);
                queueChild.clear();
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        private StringBuilder serialize(Queue<TreeNode> queue,
                               Queue<TreeNode> childQueue) {
            StringBuilder stringBuilder = new StringBuilder();
            boolean hasChild = false;
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                if(n == null) {
                    stringBuilder.append("null");
                } else {
                    hasChild = true;
                    stringBuilder.append(n.val);
                }
                stringBuilder.append(",");
                putToQueue(n, childQueue);
            }

            if(hasChild == false) {
                childQueue.clear();
                stringBuilder = new StringBuilder();
            }
            return stringBuilder;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return null;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)


}




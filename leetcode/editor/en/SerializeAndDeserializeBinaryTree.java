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
package leetcode.editor.en;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region end(Prohibit modification and deletion)
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


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    static TreeNode generateFrom(Object[] nums) {
        if(nums.length == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode t = new TreeNode((Integer) nums[0]);
        queue.add(t);

        for (int i = 1; i < nums.length ; ) {
            TreeNode node = queue.remove();

            if (null != nums[i]) {
                node.left = new TreeNode((Integer) nums[i]);
                queue.add(node.left);
            }
            i++;
            if ( i < nums.length && null != nums[i]) {
                node.right = new TreeNode((Integer) nums[i]);
                queue.add(node.right);
            }

            i++;

        }
        return t;
    }
}


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
        Codec c = new SerializeAndDeserializeBinaryTree().new Codec();
        String s = c.serialize(root);
        TreeNode t = c.deserialize(s);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Aaasdasdaasdasd
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
            StringBuilder stringBuilder = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            stringBuilder.append("[");
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                if (n == null) {
                    stringBuilder.append("null");
                } else {
                    stringBuilder.append(n.val);
                    queue.add(n.left);
                    queue.add(n.right);
                }
                stringBuilder.append(",");
            }
            stringBuilder.append("]");
            String ap = stringBuilder.toString().replaceAll("(,(null.)*)]$", "]");
            return ap;
        }


        private TreeNode getFrom(String s) {
            if (s.equals("null")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(s));
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] array = data.substring(1, data.length() - 1).split(",");
            TreeNode root = null;
            TreeNode current = null;
            Queue<TreeNode> queue = new LinkedList<>();
            int count = 0;
            int target = 0;
            for (int i = 0; i < array.length; i++) {
                String s = array[i];
                if (i == 0) {
                    root = getFrom(s);
                    queue.add(root);
                    target = 2;
                } else {
                    if (count == 0) {
                        count = target;
                        target = 0;
                    }
                    if (count > 0) {
                        TreeNode t = getFrom(s);
                        if (Math.floorMod(count, 2) == 0) {
                            current = queue.remove();
                            current.left = t;
                        } else {
                            current.right = t;
                        }
                        if (t != null) {
                            target += 2;
                            queue.add(t);
                        }
                        count--;
                    }
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)


}




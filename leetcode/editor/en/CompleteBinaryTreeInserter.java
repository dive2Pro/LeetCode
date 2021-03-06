package leetcode.editor.en;

//A complete binary tree is a binary tree in which every level, except possibly
//the last, is completely filled, and all nodes are as far left as possible. 
//
// Write a data structure CBTInserter that is initialized with a complete binary
// tree and supports the following operations: 
//
// 
// CBTInserter(TreeNode root) initializes the data structure on a given tree wit
//h head node root; 
// CBTInserter.insert(int v) will insert a TreeNode into the tree with value nod
//e.val = v so that the tree remains complete, and returns the value of the parent
// of the inserted TreeNode; 
// CBTInserter.get_root() will return the head node of the tree. 
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
//Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
//Output: [null,1,[1,2]]
// 
//
// 
// Example 2: 
//
// 
//Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,
//3,4,5,6]],[7],[8],[]]
//Output: [null,3,4,[1,2,3,4,5,6,7,8]] 
// 
//
// 
// 
//
// Note: 
//
// 
// The initial given tree is complete and contains between 1 and 1000 nodes. 
// CBTInserter.insert is called at most 10000 times per test case. 
// Every value of a given or inserted node is between 0 and 5000. 
// 
// 
// 
//
// 
// 
//
// 
// 
// Related Topics Tree


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CompleteBinaryTreeInserter {
    public static void main(String[] args) {
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
    class CBTInserter {
        List<TreeNode> list;

        public CBTInserter(TreeNode root) {

            list = new ArrayList<>();

            list.add(root);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).left != null) list.add(list.get(i).left);
                if (list.get(i).right != null) list.add(list.get(i).right);
            }
        }

        public int insert(int v) {

            int N = list.size();

            TreeNode node = new TreeNode(v);
            list.add(node);

            if (N % 2 == 1) {
                list.get((N - 1) / 2).left = node;
            } else {
                list.get((N - 1) / 2).right = node;
            }
            return list.get((N - 1) / 2).val;
        }


        public TreeNode get_root() {
            return list.get(0);
        }
    }

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
//leetcode submit region end(Prohibit modification and deletion)


}
package leetcode.editor.en;

//Given a binary tree with the following rules:
//
// 
// root.val == 0 
// If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 *
// x + 1 
// If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2
// * x + 2 
// 
//
// Now the binary tree is contaminated, which means all treeNode.val have been c
//hanged to -1. 
//
// You need to first recover the binary tree and then implement the FindElements
// class: 
//
// 
// FindElements(TreeNode* root) Initializes the object with a contamined binary 
//tree, you need to recover it first. 
// bool find(int target) Return if the target value exists in the recovered bina
//ry tree. 
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input
//["FindElements","find","find"]
//[[[-1,null,-1]],[1],[2]]
//Output
//[null,false,true]
//Explanation
//FindElements findElements = new FindElements([-1,null,-1]); 
//findElements.find(1); // return False 
//findElements.find(2); // return True 
//
// Example 2: 
//
// 
//
// 
//Input
//["FindElements","find","find","find"]
//[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
//Output
//[null,true,true,false]
//Explanation
//FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
//findElements.find(1); // return True
//findElements.find(3); // return True
//findElements.find(5); // return False 
//
// Example 3: 
//
// 
//
// 
//Input
//["FindElements","find","find","find","find"]
//[[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
//Output
//[null,true,false,false,true]
//Explanation
//FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
//findElements.find(2); // return True
//findElements.find(3); // return False
//findElements.find(4); // return False
//findElements.find(5); // return True
// 
//
// 
// Constraints: 
//
// 
// TreeNode.val == -1 
// The height of the binary tree is less than or equal to 20 
// The total number of nodes is between [1, 10^4] 
// Total calls of find() is between [1, 10^4] 
// 0 <= target <= 10^6 
// 
// Related Topics Hash Table Tree


import java.util.HashMap;

public class FindElementsInAContaminatedBinaryTree {
    public static void main(String[] args) {
//        ["FindElements","find","find","find"]
//[[[-1,-1,-1,null,null,-1,-1,null,null,null,-1]],[6],[1],[6]]
        FindElements findElements = new FindElementsInAContaminatedBinaryTree().new FindElements(TreeNode.generateFrom(new Object[]{
//                -1, null, -1
                -1, -1, -1, null, null, -1, -1, null, null, null, -1
        }));
        findElements.find(6);
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
    class FindElements {

        TreeNode root;

        HashMap<Integer, Integer> map;

        public FindElements(TreeNode root) {
            this.root = root;
            root.val = 0;
            map = new HashMap<>();
            recover(root, root.val);
        }

        private void recover(TreeNode root, int pv) {
            map.put(root.val, 1);
            if (root.left != null) {
                root.left.val = 2 * pv + 1;
                recover(root.left, root.left.val);
            }
            if (root.right != null) {
                root.right.val = 2 * pv + 2;
                recover(root.right, root.right.val);
            }
        }

        public boolean find(int target) {
            return map.containsKey(target);
        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
//leetcode submit region end(Prohibit modification and deletion)


}
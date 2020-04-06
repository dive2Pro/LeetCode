package leetcode.editor.en;

//Design a class to find the kth largest element in a stream. Note that it is th
//e kth largest element in the sorted order, not the kth distinct element. 
//
// Your KthLargest class will have a constructor which accepts an integer k and 
//an integer array nums, which contains initial elements from the stream. For each
// call to the method KthLargest.add, return the element representing the kth larg
//est element in the stream. 
//
// Example: 
//
// 
//int k = 3;
//int[] arr = [4,5,8,2];
//KthLargest kthLargest = new KthLargest(3, arr);
//kthLargest.add(3);   // returns 4
//kthLargest.add(5);   // returns 5
//kthLargest.add(10);  // returns 5
//kthLargest.add(9);   // returns 8
//kthLargest.add(4);   // returns 8
// 
//
// Note: 
//You may assume that nums' length ≥ k-1 and k ≥ 1. 
// Related Topics Heap


import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    public static void main(String[] args) {
//         Solution solution = new KthLargestElementInAStream().new Solution();
        int k = 3;
        int[] arr = new int[]{};
        KthLargest kthLargest = new KthLargestElementInAStream().new KthLargest(1, arr);
        kthLargest.add(-3);   // returns 4
        kthLargest.add(-2);   // returns 5
        kthLargest.add(-4);  // returns 5
        kthLargest.add(0);   // returns 8
        kthLargest.add(4);   // returns 8
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        class TreeNode {
            int val;
            int count = 1;
            TreeNode left;
            TreeNode right;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        TreeNode root;
        int k;
        TreeNode kth;

        public KthLargest(int k, int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                root = buildTree(root, nums[i]);
            }
            this.k = k;
        }

        private TreeNode buildTree(TreeNode node, int val) {

            if (node == null) {
                return new TreeNode(val);
            }
            if (node.val > val) {
                node.left = buildTree(node.left, val);
            } else if (node.val < val) {
                node.right = buildTree(node.right, val);
            } else {
                node.count++;
            }

            return node;
        }

        public int add(int val) {
            root = buildTree(root, val);
            kth = null;
            findBy(root, this.k);

            if (kth != null) {
                return kth.val;
            }

            return -1;
        }

        private int findBy(TreeNode node, int k) {

            if (node == null || kth != null) {
                return k;
            }

            if (node.right != null) {
                k = findBy(node.right, k);
            }


            k -= node.count;

            if (k <= 0 && kth == null) {
                kth = node;
            }

            k = findBy(node.left, k);


            return k;
        }

    }

/**
 *
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 *
 */
//leetcode submit region end(Prohibit modification and deletion)


}
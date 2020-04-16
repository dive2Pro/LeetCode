package leetcode.editor.en;

//
//Given an integer array with no duplicates. A maximum tree building on this arr
//ay is defined as follow:
// 
// The root is the maximum number in the array. 
// The left subtree is the maximum tree constructed from left part subarray divi
//ded by the maximum number. 
// The right subtree is the maximum tree constructed from right part subarray di
//vided by the maximum number. 
// 
// 
//
// 
//Construct the maximum tree by the given array and output the root node of this
// tree.
// 
//
// Example 1: 
// 
//Input: [3,2,1,6,0,5]
//Output: return the tree root node representing the following tree:
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
// 
// 
//
// Note: 
// 
// The size of the given array will be in the range [1,1000]. 
// 
// Related Topics Tree


public class MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTree().new Solution();
        solution.constructMaximumBinaryTree(new int[]{
                3, 2, 1,
                6, 0, 5});
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

        class QuickSort {
            void sort(int[] nums, int lo, int hi) {
                int pivot = genPivot(nums, lo, hi);
                if (lo < pivot)
                    sort(nums, lo, pivot);
                if (pivot + 1 < hi)
                    sort(nums, pivot + 1, hi);
            }

            private int genPivot(int[] nums, int lo, int hi) {
                int val = nums[lo];
                int pivot = lo;
                int i;
                for (i = lo + 1; i < hi; ) {
                    if (nums[i] < val) {
                        swichNums(nums, --hi, i);
                    } else if (nums[i] > val) {
                        swichNums(nums, pivot++, i++);
                    }
                }
//                swichNums(nums, lo, pivot);

                return pivot;
            }

            private void swichNums(int[] nums, int i, int pivot) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
            }
        }

        public TreeNode constructMaximumBinaryTree(int[] nums) {
//            int maxIndex = -1;
//            int max = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] > max) {
//                    max = nums[i];
//                    maxIndex = i;
//                }
//            }
//            QuickSort sort = new QuickSort();
//            sort.sort(nums, 0, maxIndex);
//            sort.sort(nums, maxIndex, nums.length);
//            TreeNode node = new TreeNode(max);
//            for (int i = 0; i < maxIndex; i++) {
//                node.left = buildTree(node.left, nums[i]);
//            }
//
//            for (int i = maxIndex + 1; i < nums.length; i++) {
//                node.right = buildTree(node.right, nums[i]);
//            }
//            return buildTree(null, nums, 0, nums.length);
            TreeNode root = buildTree(null, nums, 0, nums.length - 1);
            return root;
        }

        private TreeNode buildTree(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val > val) {
                root.left = buildTree(root.left, val);
            } else {
                root.right = buildTree(root.right, val);
            }
            return null;
        }

        private TreeNode buildTree(TreeNode root, int[] nums, int lo, int hi) {
            if (lo > hi) {
                return null;
            }
            int mostIndex = findMostIn(nums, lo, hi);
            int val = nums[mostIndex];
            if (root == null) {
                root = new TreeNode(val);
            }
            root.left = buildTree(root.left, nums, lo, mostIndex -1 );
            root.right = buildTree(root.right, nums, mostIndex + 1, hi);
            return root;
        }

        private int findMostIn(int[] nums, int lo, int hi) {
            int maxIndex = lo;
            for (int i = lo + 1; i <= hi; i++) {
                if(nums[i] > nums[maxIndex])  {
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
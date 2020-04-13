package leetcode.editor.en;

//Given an array of integers, find out whether there are two distinct indices i
//and j in the array such that the absolute difference between nums[i] and nums[j]
// is at most t and the absolute difference between i and j is at most k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3, t = 0
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1, t = 2
//Output: true
// 
//
// 
// Example 3: 
//
// 
//Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//Output: false
// 
// 
// 
// Related Topics Sort Ordered Map


import java.util.TreeSet;

public class ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        int[] nums = new int[]{1,5,9,1,5,9};
        int k = 2, t = 3;
        boolean had = solution.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(had);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * nums 中是否存在
         * nums[i] 和 nums[j] 差的绝对值 不超过 t
         * 并且 i   和      j  差的绝对值 不超过 k
         *
         * @param nums - 要检查的数组
         * @param k    -
         * @param t    -
         * @return 是否存在
         */
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (nums == null || nums.length < 2 || k < 1) {
                return false;
            }

            TreeSet<Long> treeSet = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                long c = nums[i];

                Long floor = treeSet.floor(c);
                Long ceil = treeSet.ceiling(c);

                if (floor != null && c - floor <= t
                        || ceil != null && ceil - c <= t
                ) {
                    return true;
                }

                treeSet.add(c);

                if (i >= k) {
                    treeSet.remove((long)nums[i - k]);
                }
            }

            return false;
        }

        public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 1; j <= k; j++) {
                    if (nums.length > j + i) {
                        if (Math.abs(nums[i] - nums[j + i]) <= t) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}
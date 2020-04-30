package leetcode.editor.en;

//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Determine if you are able to reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10^4 
// 0 <= nums[i][j] <= 10^5 
// 
// Related Topics Array Greedy


import java.util.ArrayList;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        solution.canJump(new int[]{
//                3, 2, 1, 1, 1,  4
//                1
                38, 2, 4, 4, 4, 9, 5, 2, 5, 8,
                8, 0, 8, 6, 9, 1, 1, 6, 3, 5,
                1, 2, 6, 6, 0, 4, 8, 6, 0, 3,
                2, 8, 7, 6, 5, 1, 7, 0, 0, 4,
                8, 3, 5, 9, 0, 4, 0, 1, 0, 5,
                9, 2, 0, 7, 0, 2, 1, 0, 8, 2,
                5, 1, 2, 3, 9, 7, 4, 7, 0, 0,
                1, 8, 5, 6, 7, 5, 1, 9, 9, 3,
                5, 0, 7, 5
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);

            while (!list.isEmpty()) {
                int size = list.remove(list.size() - 1);
                int range = nums[size];

                if (range + size >= nums.length - 1) {
                    return true;
                }

                for (int i = 1; i <= range; i++) {
                    list.add(size + i);
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
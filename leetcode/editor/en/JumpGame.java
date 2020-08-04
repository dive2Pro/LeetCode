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
        long currentTimeMillis = System.nanoTime();
        boolean can = solution.canJump(new int[]{
//                0, 1
                2,0,0
//                2,5,0,0
//                3, 2, 1, 2, 0, 4
//                3, 2, 1, 0, 4
//                2, 1, 1, 1, 0
//                32, 2, 4, 4, 4, 9, 5, 2, 5, 8,
//                8, 0, 8, 6, 9, 1, 1, 6, 3, 5,
//                1, 2, 0, 1, 0, 4, 8, 6, 0, 3,
//                2, 8, 7, 6, 5, 1, 7, 0, 0, 4,
//                8, 3, 5, 9, 0, 4, 0, 1, 0, 5,
//                9, 2, 0, 7, 0, 2, 1, 0, 8, 2,
//                5, 1, 2, 3, 9, 7, 4, 7, 0, 0,
//                1, 8, 5, 6, 7, 5, 1, 9, 9, 3,
//                5, 0, 7, 5
        });
        long currentTimeMillis2 = System.nanoTime();
        System.out.println(can);
        System.out.println(currentTimeMillis2 - currentTimeMillis);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // [[August 3, 2020]]
    class Solution {
        public boolean canJump(int[] nums) {
            if(nums.length <= 0) {
                return  false;
            }

            if(nums.length == 1) {
                return true;
            }

            int curr = nums[0];

            while(curr + 1 < nums.length) {

                if(nums[curr] == 0) {
                    int last = curr - 1;
                    int limit = last;

                    while(last > 0) {
                        if(nums[last] == 0) {
                            last = --limit;
                        } else {
                            last += nums[last];
                            if(last > curr) {
                                curr = last;
                                break;
                            }
                        }
                    }

                    if(last <= 0) {
                        return false;
                    }
                }
                if(curr > nums.length) {
                    break;
                }
                curr += nums[curr];
            }

            return true;
        }
    }

    class Solution2 {
        public boolean canJump(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);

            while (!list.isEmpty()) {
                int index = list.remove(list.size() - 1);

                int range = nums[index];

                int willDecreased = index;

                if (range + index >= nums.length - 1) {
                    return true;
                }

                // 此时检查 nums[range + index] 是否超过了 当前的 index
                // 如果没有超过 检查 index 后一位
                // 超过了 整个就可以继续
                int backWard = 1;
                while (nums[range + willDecreased] < backWard) {
                    if (willDecreased <= 0) {
                        range--;
                    } else {
                        willDecreased--;
                    }
                    backWard++;
                    if (willDecreased <= 0 && range <= 0) {
                        return false;
                    }
                }

                list.add(willDecreased + range);


            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
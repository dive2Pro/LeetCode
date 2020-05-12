//Given an array nums sorted in ascending order, return true if and only if you 
//can split it into 1 or more subsequences such that each subsequence consists of 
//consecutive integers and has length at least 3. 
//
// 
//
// Example 1: 
//
// 
//Input: [1,2,3,3,4,5]
//Output: True
//Explanation:
//You can split them into two consecutive subsequences : 
//1, 2, 3
//3, 4, 5
//
// 
//
// Example 2: 
//
// 
//Input: [1,2,3,3,4,4,5,5]
//Output: True
//Explanation:
//You can split them into two consecutive subsequences : 
//1, 2, 3, 4, 5
//3, 4, 5
//
// 
//
// Example 3: 
//
// 
//Input: [1,2,3,4,4,5]
//Output: False
// 
//
// 
//
// Constraints: 
//
// 
// 1 <= nums.length <= 10000 
// 
//
// 
// Related Topics Heap Greedy

  
package leetcode.editor.en;

public class SplitArrayIntoConsecutiveSubsequences{
    public static void main(String[] args) {
        SplitArrayIntoConsecutiveSubsequences.Solution solution =
                new SplitArrayIntoConsecutiveSubsequences().new Solution();
        boolean possible = solution.isPossible(new int[]{1,2,3,3,4,4,5,5});
        System.out.println(possible);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean can;
        boolean[] indicates;
        public boolean isPossible(int[] nums) {
            indicates = new boolean[nums.length];
            return isPossible(0, nums);
        }

        public boolean isPossible(int start, int[] nums) {
            if(start >= nums.length - 2) return false;
            int p = nums[start];
            int count = 1;
            for(int i = start + 1; i < nums.length; i ++) {
                if(indicates[i] == true) {
                    continue;
                }
                if(nums[i] - 1 == nums[i - 1]) {
                    count ++;
                    indicates[i] = true;
                } else if(nums[i]  == nums[i - 1]) {
                    if(isPossible(i, nums) == false) return false;
                } else if(nums[i] - 1 > nums[i - 1] ) {
                    if(count < 3) {
                        return false;
                    }
                    return isPossible(i, nums);
                }
            }

            return count >= 3;
        }
}
//leetcode submit region end(Prohibit modification and deletion)


}

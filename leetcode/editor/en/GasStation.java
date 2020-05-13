//There are N gas stations along a circular route, where the amount of gas at st
//ation i is gas[i]. 
//
// You have a car with an unlimited gas tank and it costs cost[i] of gas to trav
//el from station i to its next station (i+1). You begin the journey with an empty
// tank at one of the gas stations. 
//
// Return the starting gas station's index if you can travel around the circuit 
//once in the clockwise direction, otherwise return -1. 
//
// Note: 
//
// 
// If there exists a solution, it is guaranteed to be unique. 
// Both input arrays are non-empty and have the same length. 
// Each element in the input arrays is a non-negative integer. 
// 
//
// Example 1: 
//
// 
//Input: 
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//
//Output: 3
//
//Explanation:
//Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4
// = 4
//Travel to station 4. Your tank = 4 - 1 + 5 = 8
//Travel to station 0. Your tank = 8 - 2 + 1 = 7
//Travel to station 1. Your tank = 7 - 3 + 2 = 6
//Travel to station 2. Your tank = 6 - 4 + 3 = 5
//Travel to station 3. The cost is 5. Your gas is just enough to travel back to 
//station 3.
//Therefore, return 3 as the starting index.
// 
//
// Example 2: 
//
// 
//Input: 
//gas  = [2,3,4]
//cost = [3,4,3]
//
//Output: -1
//
//Explanation:
//You can't start at station 0 or 1, as there is not enough gas to travel to the
// next station.
//Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//
//Travel to station 0. Your tank = 4 - 3 + 2 = 3
//Travel to station 1. Your tank = 3 - 3 + 3 = 3
//You cannot travel back to station 2, as it requires 4 unit of gas but you only
// have 3.
//Therefore, you can't travel around the circuit once no matter where you start.
//
// 
// Related Topics Greedy

  
package leetcode.editor.en;

public class GasStation{
    public static void main(String[] args) {
         Solution solution = new GasStation().new Solution();
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

//There are N gas stations along a circular route, where the amount of gas at station
// i is gas[i].
//
// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
// from station i to its next station (i+1).
// You begin the journey with an empty tank at one of the gas stations.
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
//        int possible = solution.isPossible(new int[]{1,2,3,4,5 }, new int[] { 3, 4, 5, 1, 2});
//        int possible = solution.isPossible(new int[]{2, 3, 4}, new int[] {3, 4, 3});
//        int possible = solution.isPossible(new int[]{2, 4}, new int[] {3, 4 });
        int possible = solution.isPossible(new int[]{4}, new int[] {5 });
        System.out.println(possible);
    }
    // [[August 4, 2020]]
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         *
         * @param gas
         * @return
         */
        public int canCompleteCircuit(int[] gas, int[] costs){
            return isPossible(gas, costs);
        }
        public int isPossible(int[] gas, int[] costs) {
            if(gas.length == 1) {
                return gas[0] - costs[0] >= 0 ? 0 : -1;
            }
            // greedy
            // 找到某个起点，这个起点出发，向右可以绕一圈回到起点
            // 从 A 开始，如果到C处，不支持到D了
            // 设置起点为 E，检查是否能到 A 处，
                // 如果能到 A，检查剩余是否满足 C 和 D 的 gap
                    // 如果满足
                        // 则继续检查能否到 E
                    // 如果不满足
                        // 检查 E 的后一位 D
            int gap = 0;
            int start = 0;
            int next = 0;
            int total = 0;
            int cost = 0;
            int end = gas.length - 1;

            while(next != start || next == 0) {
                if(next > end) {
                    return start;
                }
                total += gas[next];
                cost = costs[next];
                if(total - cost < 0) {
                    // 往后设置 start
                    gap = total - cost;
                    start -= 1;
                    while(gap < 0) {

                        if(start == next) {
                            return -1;
                        }

                        if (start <= 0) {
                            start = end;
                        }
                        gap +=  gas[start] - costs[start];
                        if(gap < 0) {
                            start -= 1;
                        }
                    }
                    total = gap;
                } else {
                    total -= cost;
                }
                next += 1;
            }

            return start;
        }
    }

    class Solution2 {
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

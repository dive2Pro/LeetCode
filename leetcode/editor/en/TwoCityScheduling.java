package leetcode.editor.en;

//There are 2N people a company is planning to interview. The cost of flying the
// i-th person to city A is costs[i][0], and the cost of flying the i-th person to
// city B is costs[i][1]. 
//
// Return the minimum cost to fly every person to a city such that exactly N peo
//ple arrive in each city. 
//
// 
//
// Example 1: 
//
// 
//Input: [[10,20],[30,200],[400,50],[30,20]]
//Output: 110
//Explanation: 
//The first person goes to city A for a cost of 10.
//The second person goes to city A for a cost of 30.
//The third person goes to city B for a cost of 50.
//The fourth person goes to city B for a cost of 20.
//
//The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people inte
//rviewing in each city.
// 
//
// 
//
// Note: 
//
// 
// 1 <= costs.length <= 100 
// It is guaranteed that costs.length is even. 
// 1 <= costs[i][0], costs[i][1] <= 1000 
// Related Topics Greedy

import java.util.Arrays;

public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] ints = new int[4][2];
        ints[0] = new int[]{689, 863};
        ints[1] = new int[]{721, 888};
        ints[2] = new int[]{975, 843};
        ints[3] = new int[]{175, 221};
        Solution solution = new TwoCityScheduling().new Solution();
        solution.twoCitySchedCost(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, (p, q) -> {
                return (p[0] - p[1]) - (q[0] - q[1]);
            });

            int sum = 0;
            for (int i = 0; i < costs.length; i++) {
                if (i < costs.length / 2) {
                    sum += costs[i][0];
                } else {
                    sum += costs[i][1];
                }
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
package leetcode.editor.en;

//Balanced strings are those who have equal quantity of 'L' and 'R' characters.
//
//
// Given a balanced string s split it in the maximum amount of balanced strings.
// 
//
// Return the maximum amount of splitted balanced strings. 
//
// 
// Example 1: 
//
// 
//Input: s = "RLRRLLRLRL"
//Output: 4
//Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring cont
//ains same number of 'L' and 'R'.
// 
//
// Example 2: 
//
// 
//Input: s = "RLLLLRRRLR"
//Output: 3
//Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains
// same number of 'L' and 'R'.
// 
//
// Example 3: 
//
// 
//Input: s = "LLLLRRRR"
//Output: 1
//Explanation: s can be split into "LLLLRRRR".
// 
//
// Example 4: 
//
// 
//Input: s = "RLRRRLLRLL"
//Output: 2
//Explanation: s can be split into "RL", "RRRLLRLL", since each substring contai
//ns an equal number of 'L' and 'R'
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s[i] = 'L' or 'R' 
// 
// Related Topics String Greedy


import java.util.Deque;
import java.util.LinkedList;

public class SplitAStringInBalancedStrings {
    public static void main(String[] args) {
        Solution solution = new SplitAStringInBalancedStrings().new Solution();
//        solution.balancedStringSplit("RLRRLLRLRL");
        solution.balancedStringSplit("RLLLLRRRLR");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int balancedStringSplit(String s) {
            Deque<Character> deque = new LinkedList<>();
            int lCount = 0;
            int rCount = 0;
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'L') {
                    lCount += 1;
                } else {
                    rCount += 1;
                }

                if (lCount == rCount) {
                    count++;
                    lCount = 0;
                    rCount = 0;
                }

            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
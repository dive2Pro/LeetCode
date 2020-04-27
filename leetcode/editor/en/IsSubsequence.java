package leetcode.editor.en;

//
//Given a string s and a string t, check if s is subsequence of t.
// 
//
// 
//You may assume that there is only lower case English letters in both s and t. 
//t is potentially a very long (length ~= 500,000) string, and s is a short string
// (<=100).
// 
//
// 
//A subsequence of a string is a new string which is formed from the original st
//ring by deleting some (can be none) of the characters without disturbing the rel
//ative positions of the remaining characters. (ie, "ace" is a subsequence of "abc
//de" while "aec" is not).
// 
//
// Example 1: 
//s = "abc", t = "ahbgdc"
// 
// 
//Return true.
// 
//
// Example 2: 
//s = "axc", t = "ahbgdc"
// 
// 
//Return false.
// 
//
// Follow up: 
//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you w
//ant to check one by one to see if T has its subsequence. In this scenario, how w
//ould you change your code? 
//
// Credits: Special thanks to @pbrother for adding this problem and creating all
// test cases. Related Topics Binary Search Dynamic Programming Greedy


public class IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new IsSubsequence().new Solution();
        solution.isSubsequence("abc", "ahbgdc");
        solution.isSubsequence("ccc", "ahbgdc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int j = 0;
            int i = 0;
            char[] sAry = s.toCharArray();
            char[] tAry = t.toCharArray();
            boolean runOut = s.equals("");
            for (; i < sAry.length; i++) {
                char c = sAry[i];
                while (j < tAry.length) {
                    if (c == (tAry[j++])) {
                        runOut = i == sAry.length - 1;
                        break;
                    }
                }
            }

            return runOut;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
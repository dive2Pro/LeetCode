//Given a string S, check if the letters can be rearranged so that two character
//s that are adjacent to each other are not the same. 
//
// If possible, output any possible result. If not possible, return the empty st
//ring. 
//
// Example 1: 
//
// 
//Input: S = "aab"
//Output: "aba"
// 
//
// Example 2: 
//
// 
//Input: S = "aaab"
//Output: ""
// 
//
// Note: 
//
// 
// S will consist of lowercase letters and have length in range [1, 500]. 
// 
//
// 
// Related Topics String Heap Greedy Sort


package leetcode.editor.en;

public class ReorganizeString {
    public static void main(String[] args) {
        Solution solution = new ReorganizeString().new Solution();
//        solution.reorganizeString("aab");
//        solution.reorganizeString("aaab");
        solution.reorganizeString("baaba");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        void swap(char[] cs, int i, int p) {
            char temp = cs[i];
            cs[i] = cs[p];
            cs[p] = temp;
        }

        public String reorganizeString(String S) {
            if (S == null || S.length() == 0) {
                return "";
            }
            if (S.length() == 1) {
                return S;
            }

            StringBuilder sb = new StringBuilder();
            char[] cs = S.toCharArray();
            int j = 0;
            for (int i = 1; i < S.length(); i++) {
                char c = cs[i];
                if (c == cs[i - 1]) {
                    j = i + 1;
                    for (; j < S.length(); j++) {
                        if (cs[j] != c) {
                            swap(cs, i, j);
                            break;
                        }
                    }
                    if (j == S.length()) {
                        return "";
                    }
                }
            }

            String result = String.valueOf(cs);

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

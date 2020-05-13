//
//A string S of lowercase letters is given. We want to partition this string int
//o as many parts as possible so that each letter appears in at most one part, and
// return a list of integers representing the size of these parts.
// 
//
// Example 1: 
// 
//Input: S = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it split
//s S into less parts.
// 
// 
//
// Note: 
// S will have length in range [1, 500]. 
// S will consist of lowercase letters ('a' to 'z') only. 
// Related Topics Two Pointers Greedy


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new PartitionLabels().new Solution();
        solution.partitionLabels("ababcbacadefegdehijhklij");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String S) {
            char[] cs = S.toCharArray();

            int longest = 0;
            HashMap<Character, Integer> map = new HashMap<>();

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < cs.length; i++) {
                map.put(cs[i], i);
            }

            while (longest < cs.length) {
                int prev = longest;
                for ( int k = longest; k < map.get(cs[longest]); k ++) {
                    if(longest < map.get(cs[k])) {
                        longest = map.get(cs[k]);
                    }
                }
                result.add(longest - prev + 1);
                longest ++;
            }


            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

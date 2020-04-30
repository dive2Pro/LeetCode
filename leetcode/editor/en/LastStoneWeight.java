package leetcode.editor.en;

//We have a collection of stones, each stone has a positive integer weight.
//
// Each turn, we choose the two heaviest stones and smash them together. Suppose
// the stones have weights x and y with x <= y. The result of this smash is: 
//
// 
// If x == y, both stones are totally destroyed; 
// If x != y, the stone of weight x is totally destroyed, and the stone of weigh
//t y has new weight y-x. 
// 
//
// At the end, there is at most 1 stone left. Return the weight of this stone (o
//r 0 if there are no stones left.) 
//
// 
//
// Example 1: 
//
// 
//Input: [2,7,4,1,8,1]
//Output: 1
//Explanation: 
//We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
//we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
//we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//we combine 1 and 1 to get 0 so the array converts to [1] then that's the value
// of last stone. 
//
// 
//
// Note: 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics Heap Greedy


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LastStoneWeight {
    public static void main(String[] args) {
        Solution solution = new LastStoneWeight().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastStoneWeight(int[] stones) {
            Arrays.sort(stones);
            ArrayList<Integer> list = new ArrayList<>();

            for (int v : stones) {
                list.add(v);
            }

            while (list.size() > 1) {
                int last = list.remove(list.size() - 1);
                int latter = list.remove(list.size() - 1);
                int diff = Math.abs(last - latter);
                if (diff > 0) {
                    insertTo(list, diff);
                }
            }

            return list.size() == 0 ? 0 : list.get(0);
        }

        private void insertTo(ArrayList<Integer> sortedList, int diff) {
            sortedList.add(diff);
            Collections.sort(sortedList);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
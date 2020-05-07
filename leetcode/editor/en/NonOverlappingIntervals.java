package leetcode.editor.en;

//Given a collection of intervals, find the minimum number of intervals you need
// to remove to make the rest of the intervals non-overlapping. 
//
// 
// 
//
// 
//
// Example 1: 
//
// 
//Input: [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of intervals are non-overlappin
//g.
// 
//
// Example 2: 
//
// 
//Input: [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of intervals non-ov
//erlapping.
// 
//
// Example 3: 
//
// 
//Input: [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're alrea
//dy non-overlapping.
// 
//
// 
//
// Note: 
//
// 
// You may assume the interval's end point is always bigger than its start point
//. 
// Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap
// each other. 
// 
// Related Topics Greedy


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


class IntArrayGenerator {

    private static String removeBracket(String str) {
        str = str.trim();
        return str.substring(0, str.length() - 1)
                .substring(1);
    }

    // [1,100],[11,22],[1,11],[2,12]
    public static int[][] generator(String str) {
        str = removeBracket(str);
        str = str.replaceAll("],", "]],");
        String[] strings = str.split("],");
        int[][] ints = new int[strings.length][2];

        for (int i = 0; i < strings.length; i++) {
            String[] c = removeBracket(strings[i]).split(",");
            ints[i] = new int[]{
                    Integer.parseInt(c[0].trim()),
                    Integer.parseInt(c[1].trim())
            };
        }
        return ints;
    }
}

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
//        solution.eraseOverlapIntervals(IntArrayGenerator.generator("[[1,2],[1,2],[1,2]]"));
//        solution.eraseOverlapIntervals(IntArrayGenerator.generator("[[1,100],[11,22],[1,11],[2,12]]"));
//        solution.eraseOverlapIntervals(IntArrayGenerator.generator("[[1,2],[2,3],[3,4],[1,3]]"));
//        solution.eraseOverlapIntervals(IntArrayGenerator.generator("[[1,100],[11,22],[1,11],[12,13]]"));
        assert solution.eraseOverlapIntervals(IntArrayGenerator.generator("[[5,9],[11,22],[1,11], [12, 13],[13, 14]]")) == 2;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            ArrayList<Deque<int[]>> list = new ArrayList<>();
            Deque<int[]> deque = new ArrayDeque<>();
            int k = 0;
            for (int[] interval : intervals) {
                while (deque.size() > 0 && (
                        interval[0] < deque.peekLast()[1]
                                || interval[1] <= deque.peekLast()[1]
                )) {
                    list.add(deque);
                    deque = new ArrayDeque<>();
                }

                deque.add(interval);
            }

            return k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
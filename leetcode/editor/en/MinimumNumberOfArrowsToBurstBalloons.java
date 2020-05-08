package leetcode.editor.en;

//There are a number of spherical balloons spread in two-dimensional space. For
//each balloon, provided input is the start and end coordinates of the horizontal 
//diameter. Since it's horizontal, y-coordinates don't matter and hence the
// x-coordinates of start and end of the diameter suffice. Start is always smaller than e
//nd. There will be at most 10^4 balloons.
//
// An arrow can be shot up exactly vertically from different points along the x-
//axis. A balloon with x-start and x-end bursts by an arrow shot at x if x-start ≤ x
//≤ x-end. There is no limit to the number of arrows that can be shot. An arrow once
// shot keeps travelling up infinitely. The problem is to find the minimum number
// of arrows that must be shot to burst all balloons. 
//
// Example: 
//
// 
//Input:
//[[10,16], [2,8], [1,6], [7,12]]
//
//Output:
//2
//
//Explanation:
//One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8
//] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
// 
//
// 
// Related Topics Greedy


import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfArrowsToBurstBalloons().new Solution();
        solution.findMinArrowShots(IntArrayGenerator.generator("[[10,16], [2,8], [1,6], [7,12]]"));
        solution.findMinArrowShots(IntArrayGenerator.generator("[[10,16], [0, 1], [2,8], [1,6], [7,12]]"));
        solution.findMinArrowShots(IntArrayGenerator.generator("[[10,16], [0, 1], [0, 22], [2,8], [1,6], [7,12]]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) return 0;
            Arrays.sort(points, (p, q) -> {
                return q[0] - p[0] == 0 ? p[1] - q[1] : p[0] - q[0];
            });

            int start = points[0][0];
            int end = points[0][1];

            int k = 1;

            for (int i = 1; i < points.length; i++) {
                int[] point = points[i];
                if (start == point[0]) {
                    if (point[1] < end) {
                        end = point[1];
                    }
                } else if (point[0] > end) {
                    k++;
                    start = point[0];
                    end = point[1];
                } else {
                    start = point[0];
                    if (point[1] < end) {
                        end = point[1];
                    }
                }
            }

            return k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
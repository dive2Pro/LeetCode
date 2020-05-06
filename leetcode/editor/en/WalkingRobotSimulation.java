package leetcode.editor.en;

//A robot on an infinite grid starts at point (0, 0) and faces north. The robot
//can receive one of three possible types of commands: 
//
// 
// -2: turn left 90 degrees 
// -1: turn right 90 degrees 
// 1 <= x <= 9: move forward x units 
// 
//
// Some of the grid squares are obstacles. 
//
// The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1]) 
//
// If the robot would try to move onto them, the robot stays on the previous gri
//d square instead (but still continues following the rest of the route.) 
//
// Return the square of the maximum Euclidean distance that the robot will be fr
//om the origin. 
//
// 
//
// Example 1: 
//
// 
//Input: commands = [4,-1,3], obstacles = []
//Output: 25
//Explanation: robot will go to (3, 4)
// 
//
// 
// Example 2: 
//
// 
//Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//Output: 65
//Explanation: robot will be stuck at (1, 4) before turning left and going to (1
//, 8)
// 
// 
//
// 
//
// Note: 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// The answer is guaranteed to be less than 2 ^ 31. 
// 
// Related Topics Greedy


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WalkingRobotSimulation {
    public static void main(String[] args) {
        Solution solution = new WalkingRobotSimulation().new Solution();
//        solution.robotSim(
//                new int[]{4, -1, 3},
//                new int[][]{}
//        );

        int[][] obstacles = new int[10][2];
        obstacles[0] = new int[]{-4, -1};
        obstacles[1] = new int[]{1, -1};
        obstacles[2] = new int[]{1, 4};
        obstacles[3] = new int[]{5, 0};
        obstacles[4] = new int[]{4, 5};
        obstacles[5] = new int[]{-2, -1};
        obstacles[6] = new int[]{2, -5};
        obstacles[7] = new int[]{5, 1};
        obstacles[8] = new int[]{-3, -1};
        obstacles[9] = new int[]{5, -3};

        int v = solution.robotSim(
                new int[]{
                        -1,5,5,-2,6,6,7,7,2,8,9,-1,7,4,6,9,9,9,-1,5,1,3,3,-1,5,9,7,4,8
                },
//                obstacles
                new int[][]{}
        );
        System.out.println(v);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int direction = 0;


        public int robotSim(int[] commands, int[][] obstacles) {
            int[][] directions = new int[4][2];
            directions[3] = new int[]{0, 1};
            directions[0] = new int[]{1, 0};
            directions[1] = new int[]{0, -1};
            directions[2] = new int[]{-1, 0};

            int[] currPosition = new int[]{0, 0};
            int[] nextPosition = new int[]{0, 0};

            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
            for (int[] obstacle : obstacles) {
                map.computeIfAbsent(obstacle[0], k -> new HashSet<>());
                map.get(obstacle[0]).add(obstacle[1]);
            }

            for (int command : commands) {
                if (command < 0) {
                    turnDirection(command);
                } else {
                    int[] diff = directions[direction];
                    int[] movement = new int[2];

                    while (command-- > 0) {
                        movement[0] = diff[0];
                        movement[1] = diff[1];
                        nextPosition[0] = movement[0] + currPosition[0];
                        nextPosition[1] = movement[1] + currPosition[1];
                        if (canGoNext(nextPosition, map)) {
                            currPosition[0] = nextPosition[0];
                            currPosition[1] = nextPosition[1];
                        } else {
                            break;
                        }
                    }
                }
            }
            return currPosition[0] * currPosition[0] + currPosition[1] * currPosition[1];
        }

        private boolean canGoNext(int[] nextPosition, HashMap<Integer, HashSet<Integer>> obstacles) {

            if (obstacles.get(nextPosition[0]) != null) {
                return !obstacles.get(nextPosition[0]).contains(nextPosition[1]);
            }

            return true;
        }

        private void turnDirection(int angle) {
            direction = (direction + (angle == -2 ? -1 : 1)) % 4;
            if (direction < 0) {
                direction += 4;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
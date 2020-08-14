package leetcode.editor.en;

//You are given a char array representing tasks CPU need to do. It contains capi
//tal letters A to Z where each letter represents a different task. Tasks could be
// done without the original order of the array. Each task is done in one unit of 
//time. For each unit of time, the CPU could complete either one task or just be i
//dle. 
//
// However, there is a non-negative integer n that represents the cool down period
// between two same tasks (the same letter in the array), that is that there must
// be at least n units of time between any two same tasks. 
//
// You need to return the least number of units of times that the CPU will take 
//to finish all the given tasks. 
//
// 
// Example 1: 
//
// 
//Input: tasks = ['A','A','A','B','B','B'], n = 2
//Output: 8
//Explanation: 
//A -> B -> idle -> A -> B -> idle -> A -> B
//There is at least 2 units of time between any two same tasks.
// 
//
// Example 2: 
//
// 
//Input: tasks = ['A','A','A','B','B','B'], n = 0
//Output: 6
//Explanation: On this case any permutation of size 6 would work since n = 0.
//['A','A','A','B','B','B']
//['A','B','A','B','A','B']
//['B','B','B','A','A','A']
//...
//And so on.
// 
//
// Example 3: 
//
// 
//Input: tasks = ['A','A','A','A','A','A','B','C','D','E','F','G'], n = 2
//Output: 16
//Explanation: 
//One possible solution is
//A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle ->
// idle -> A
// 
//
// 
// Constraints: 
//
// 
// The number of tasks is in the range [1, 10000]. 
// The integer n is in the range [0, 100]. 
// 
// Related Topics Array Greedy Queue 
// 👍 3517 👎 706


import java.util.HashMap;
import java.util.TreeMap;

public class TaskScheduler {
    public static void main(String[] args) {
        Solution solution = new TaskScheduler().new Solution();
        int result =  solution.leastInterval(new char[]{
//                        'A', 'A', 'A',  'B', 'B', 'B'
                'A','A','A','A','A','A','B','C','D','E','F','G'
        } , 1);
        // ABACADAEAFAG
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            // 因为 tasks 都要完成的
            // 变成求得最少的 idle 状态
            // 假设最多的值为  A
            // n 表示 两个 A _ _ A 之间的个数
            // 求出所有的n的和
            // 此时如果 其他 tasks 没有大于这个数的话，结果就是这个数
            // 如果其他 tasks 大于 这个数，那么这个数就是 tasks 的个数
            // 如果有多个和 A 相同数量的任务, 有 k 个的话
            //  n = n - k
            // 现在还有个问题，如何计算存在于 A 间的空格和非A值(比A次数少）的数量
                //  非 A 值是

            // 🧙
            int largest = 0;
            int largestCount = 0;

            TreeMap<String, Integer> treeMap = new TreeMap<>();
            // 求得出现次数最多的值
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < tasks.length; i++) {
                char c = tasks[i];
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) > largest) {
                    largest = map.get(c);
                    largestCount = 1;
                } else if (map.get(c) == largest) {
                    largestCount++;
                }
            }

            int space = Math.max(n - largestCount + 1, 0);
            int spaceSize = largest - 1;
            int largestTotal = largestCount * largest;
            int spaceTotal = space * spaceSize;

            return  largestTotal + Math.max(spaceTotal, tasks.length - largestTotal);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
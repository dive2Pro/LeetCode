package leetcode.editor.en;

//Suppose you have a random list of people standing in a queue. Each person is d
//escribed by a pair of integers (h, k), where h is the height of the person and k
// is the number of people in front of this person who have a height greater than 
//or equal to h. Write an algorithm to reconstruct the queue. 
//
// Note: 
//The number of people is less than 1,100. 
// 
//
// Example 
//
// 
//Input:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//Output:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
//
// 
// Related Topics Greedy


import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        Solution solution = new QueueReconstructionByHeight().new Solution();
        int[][] ints = new int[10][2];
        ints[0] = new int[]{0, 0};
        ints[1] = new int[]{6, 2};
        ints[2] = new int[]{5, 5};
        ints[3] = new int[]{4, 3};
        ints[4] = new int[]{5, 2};
        ints[5] = new int[]{1, 1};
        ints[6] = new int[]{6, 0};
        ints[7] = new int[]{6, 3};
        ints[8] = new int[]{7, 0};
        ints[9] = new int[]{5, 1};

        solution.reconstructQueue(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            TreeMap<Integer, PriorityQueue<Integer>> treeMap = new TreeMap<>();

            for (int i = 0; i < people.length; i++) {
                if (treeMap.get(people[i][0]) == null) {
                    treeMap.put(people[i][0], new PriorityQueue<>());
                }

                treeMap.get(people[i][0])
                        .add(people[i][1]);
            }

            ArrayList<int[]> arrayList = new ArrayList<>();

            while (!treeMap.isEmpty()) {
                Map.Entry<Integer, PriorityQueue<Integer>> entry = treeMap.pollLastEntry();
                int key = entry.getKey();
                PriorityQueue<Integer> values = entry.getValue();
                while (!values.isEmpty()) {
                    int position = values.poll();
                    int n = 0;
                    int j = 0;
                    for (; j < arrayList.size(); j++) {
                        if (n >= position) {
                            break;
                        }
                        int[] cp = arrayList.get(j);
                        if (cp[0] >= key) {
                            n++;
                        }
                    }
                    arrayList.add(j, new int[]{key, position});
                }
            }
            int[][] sortedPeople = new int[people.length][2];
            for (int i = 0; i < arrayList.size(); i++) {
                sortedPeople[i] = arrayList.get(i);
            }
            return sortedPeople;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
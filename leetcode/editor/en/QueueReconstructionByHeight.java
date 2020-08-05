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


import java.util.*;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        Solution solution = new QueueReconstructionByHeight().new Solution();
//        int[][] ints = new int[10][2];
//        ints[0] = new int[]{0, 0};
//        ints[1] = new int[]{6, 2};
//        ints[2] = new int[]{5, 5};
//        ints[3] = new int[]{4, 3};
//        ints[4] = new int[]{5, 2};
//        ints[5] = new int[]{1, 1};
//        ints[6] = new int[]{6, 0};
//        ints[7] = new int[]{6, 3};
//        ints[8] = new int[]{7, 0};
//        ints[9] = new int[]{5, 1};
        int[][] ints = new int[6][2];
        ints[0] = new int[] {7, 0};
        ints[1] = new int[] {4, 4};
        ints[2] = new int[] {7, 1};
        ints[3] = new int[] {5, 0};
        ints[4] = new int[] {6, 1};
        ints[5] = new int[] {5, 2};

        solution.reconstructQueue(ints);
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
       // [[August 5, 2020]]
        public int[][] reconstructQueue(int[][] people) {
            if(people.length == 0) {
                return people;
            }
            // Greedy
            // 遍历时， result 中永远是已经排好位置的
            // k 值小的的优先处理
            // 当 people 中要加入时，才好找到 [0] [1] 的限制位置
            int[][] result = new int[people.length][people[0].length];


            Arrays.sort(people, (a, b) -> {
                // 比较 [1] 和 [0]

                return (a[1] - b[1] == 0 ?  (b[0] - a[0]) : a[1] - b[1]);
            });

            ArrayList<int[]> array = new ArrayList<>();

            for (int i = 0; i < people.length; i++) {
                int[] c = people[i];
                // 找不小于 c[0] 个 c[1]数的位置
                int index = 0;

                int count = c[1];
                while (count != 0) {
                    // 找和 count 个不小于 c[0] 的数
                    for(int k = 0 ; k < array.size(); k ++) {
                        int[] p = array.get(k);
                        // [7,0] [6,0]
                        // 找到比
                        if(p[0] >= c[0]) {
                            count --;
                        }
                        if(count == 0) {
                            index = k + 1;
                            break;
                        }
                    }
                }

                array.add(index, c);
            }

            for (int i = 0; i < array.size(); i++) {
                result[i] = array.get(i);
            }
            return result;
        }
    }

    class Solution2 {
        public int[][] reconstructQueue(int[][] people) {
            TreeMap<Integer, TreeSet<Integer>> treeMap = new TreeMap<>();

            for (int[] person : people) {
                if (treeMap.get(person[0]) == null) {
                    treeMap.put(person[0], new TreeSet<>());
                }
                treeMap.get(person[0]).add(person[1]);
            }

            ArrayList<int[]> arrayList = new ArrayList<>();

            while (!treeMap.isEmpty()) {
                Map.Entry<Integer, TreeSet<Integer>> entry = treeMap.pollLastEntry();
                int key = entry.getKey();
                TreeSet<Integer> values = entry.getValue();
                for (int position : values) {
                    arrayList.add(position, new int[]{key, position});
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
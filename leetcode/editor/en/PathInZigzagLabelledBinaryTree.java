package leetcode.editor.en;

//In an infinite binary tree where every node has two children, the nodes are la
//belled in row order. 
//
// In the odd numbered rows (ie., the first, third, fifth,...), the labelling is
// left to right, while in the even numbered rows (second, fourth, sixth,...), the
// labelling is right to left. 
//
// 
//
// Given the label of a node in this tree, return the labels in the path from the
// root of the tree to the node with that label.
//
// 
// Example 1: 
//
// 
//Input: label = 14
//Output: [1,3,4,14]
// 
//
// Example 2: 
//
// 
//Input: label = 26
//Output: [1,2,6,10,26]
// 
//
// 
// Constraints: 
//
// 
// 1 <= label <= 10^6 
// 
// Related Topics Math Tree


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    public static void main(String[] args) {
        Solution solution = new PathInZigzagLabelledBinaryTree().new Solution();
//        List<Integer> path = solution.pathInZigZagTree(5);
//        List<Integer> path = solution.pathInZigZagTree(16);
        List<Integer> path = solution.pathInZigZagTree(26);
//        path = solution.pathInZigZagTree(16);
        System.out.println(path);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            List<Integer> list = new ArrayList<>();

            int lab = label;
            int level = 1;
            while (label > 1) {
                level += 1;
                label = (label) / 2;
            }
            HashMap<Integer, int[]> map = generatorLimitBy(level);
            while (level != 1) {
                list.add(0, lab);
                lab = findParentIn(list, map.get(level), lab, level % 2 == 0);
                level--;
            }
            list.add(0, 1);
            return list;
        }

        private int findParentIn(List<Integer> list, int[] minMax, int val, boolean isReverse) {

            if (isReverse) {
                int i, left = minMax[0];
                for (i = minMax[1]; i >= minMax[0]; i--, left++) {
                    if (val == i) {
                        return i % 2 != 1 ? (left - 1) / 2 : left / 2;
                    }
                }
            } else {
                int i, right = minMax[1];
                for (i = minMax[0]; i <= minMax[1]; i++, right--) {
                    if (val == i) {
                        return val % 2 != 1 ? (right - 1) / 2 : right / 2;
                    }
                }
            }
            return -1;
        }

        private HashMap<Integer, int[]> generatorLimitBy(int level) {
            HashMap<Integer, int[]> map = new HashMap<>();
            map.put(1, new int[]{1, 1});
            for (int i = 2; i <= level; i++) {
                int min = map.get(i - 1)[1];
                map.put(i, new int[]{min + 1, (int) (Math.pow(2, i - 1) + min)});
            }
            return map;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
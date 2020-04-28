package leetcode.editor.en;

//Given an array A of integers, we must modify the array in the following way: w
//e choose an i and replace A[i] with -A[i], and we repeat this process K times in
// total. (We may choose the same index i multiple times.) 
//
// Return the largest possible sum of the array after modifying it in this way. 
//
//
// 
//
// Example 1: 
//
// 
//Input: A = [4,2,3], K = 1
//Output: 5
//Explanation: Choose indices (1,) and A becomes [4,-2,3].
// 
//
// 
// Example 2: 
//
// 
//Input: A = [3,-1,0,2], K = 3
//Output: 6
//Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
// 
//
// 
// Example 3: 
//
// 
//Input: A = [2,-3,-1,5,-4], K = 2
//Output: 13
//Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
// 
// 
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length <= 10000 
// 1 <= K <= 10000 
// -100 <= A[i] <= 100 
// 
// Related Topics Greedy


import java.util.Arrays;
import java.util.Collections;

public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new MaximizeSumOfArrayAfterKNegations().new Solution();
//        solution.largestSumAfterKNegations(new int[]{4, 2, 3}, 1);
//        solution.largestSumAfterKNegations(new int[]{ -2, 9, 9, 8, 4}, 5);
        solution.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // K 表示选择多少个数( 这个数可以是相同位置 )进行 Negation
        public int largestSumAfterKNegations(int[] A, int K) {
            int sum = 0;

            Arrays.sort(A);

            boolean hasZero = false;
            int negativeCount = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] < 0 && K > 0) {
                    K--;
                    A[i] = -A[i];
                    sum += A[i];
                    continue;
                }
                negativeCount = i - 1;
                if (A[i] == 0) {
                    hasZero = true;
                } else {
                    if (!hasZero && K > 0) {
                        break;
                    }
                    sum += A[i];
                }
            }

            if (hasZero || K == 0) {
                return sum;
            }

            sum = 0;

            Arrays.sort(A);

            K = K % 2;
            for (int value : A) {
                if (K-- > 0) {
                    sum -= value;
                } else {
                    sum += value;
                }
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
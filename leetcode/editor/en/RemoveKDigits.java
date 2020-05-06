package leetcode.editor.en;

//Given a non-negative integer num represented as a string, remove k digits from
// the number so that the new number is the smallest possible.
// 
//
// Note: 
// 
// The length of num is less than 10002 and will be ≥ k. 
// The given num does not contain any leading zero. 
// 
//
// 
//
// Example 1:
// 
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 w
//hich is the smallest.
// 
// 
//
// Example 2:
// 
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output 
//must not contain leading zeroes.
// 
// 
//
// Example 3:
// 
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with nothing
// which is 0.
// 
// Related Topics Stack Greedy


import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
//        solution.removeKdigits("112", 1);
//        solution.removeKdigits("43214321", 4);
        solution.removeKdigits("99641436378815361156618888889974201828636847894114849949764848", 20);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int findLeast(String high, int lo, int hi) {
            if (lo >= hi) return -1;
            char least = high.charAt(lo);
            int minIndex = lo;
            for (int i = lo + 1; i < hi; i++) {
                if (least > high.charAt(i)) {
                    least = high.charAt(i);
                    minIndex = i;
                }
            }

            return minIndex;
        }

        public String removeKdigits(String num, int k) {

            String low = num.substring(k);
            Deque<Character> deque = new LinkedList<>();

            int least = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                deque.push(num.charAt(i));
                if (least > num.charAt(i)) {
                    least = num.charAt(i);
                }
            }

            while (!deque.isEmpty()) {
                if (deque.peek() == least) {
                    break;
                }
                deque.poll();
            }

            int lo = 0;
            int hi = k;
            int theLeast;
            int j = 0;
            int preLeast = 0;
            StringBuilder sb = new StringBuilder();
            while ((theLeast = findLeast(num, lo, hi)) != -1) {
                k = k - (theLeast - preLeast);
                preLeast = theLeast;
                if (theLeast == hi - 1) {
                    // 找到 low 中等于或小于 low.charAt(lo) 的位置
                    int biggest = j;
                    int i = j + 1;
                    StringBuilder lowSb = new StringBuilder();
                    for (; i < low.length(); i++) {
                        if (low.charAt(i) <= low.charAt(j)) {
                            break;
                        } else {
                            if (low.charAt(biggest) < low.charAt(i)) {
                                biggest = i;
                            }
                        }
                    }
                    lowSb.append(low);
                    lowSb.deleteCharAt(biggest);
                    lowSb.insert(0, num.charAt(theLeast));
                    sb.append(lowSb);
                    lo = theLeast + 1;
                } else {
                    if (low.charAt(j) > num.charAt(theLeast)) {
                        sb.append(num.charAt(theLeast));
                        lo = theLeast + 1;
                        j++;
                    } else if (low.charAt(j) == num.charAt(theLeast)) {
//                        sb.append(num.charAt(theLeast));
                        sb.append("D");
                        j++;
                    }
                }
            }


            if (sb.length() == 0) {
                return "0";
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
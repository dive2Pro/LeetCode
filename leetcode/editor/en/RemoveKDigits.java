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


import java.util.ArrayDeque;
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


        public String removeKdigits(String num, int k) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : num.toCharArray()) {
                while (k > 0 && !deque.isEmpty() && deque.peekLast() > c) {
                    deque.removeLast();
                    k--;
                }
                deque.add(c);
            }

            while (k > 0) {
                k--;
                deque.removeLast();
            }


            StringBuilder sb = new StringBuilder();

            while (!deque.isEmpty() && deque.getFirst() == '0') deque.removeFirst();

            while (!deque.isEmpty()) sb.append(deque.removeFirst());

            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
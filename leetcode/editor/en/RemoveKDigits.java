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
//        solution.removeKdigits("10", 2);
//        solution.removeKdigits("43214321", 4);
        String s = solution.removeKdigits("43210432", 3);
//        solution.removeKdigits("99641436378815361156618888889974201828636847894114849949764848", 20);
        System.out.println(s);
    }
    // [[August 4, 2020]]
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String digit, int k) {
            // 将 digit 代表的数字 移去 k 位，要求得到一个最小的数
            // digit 和生成的 首位非 0
            // 每次要删的都是最大的
            // 删除时找到最小的
            // 最小的前面的删完后
            // 再找最小的后的最小的
            // 删除这段区间的最大的
            // -----

            // 遍历数组，当前的 char 如果小于之前加入的则将之前加入的删除

            Deque<Character> deque = new ArrayDeque<>();

            for(char c: digit.toCharArray()) {
                while(k > 0 && !deque.isEmpty() && deque.peekLast() > c) {
                    k --;
                    deque.removeLast();
                }
                deque.add(c);
            }

            while (k > 0) {
                k --;
                deque.removeLast();
            }

            while (!deque.isEmpty() && deque.peekFirst() == '0') {
                deque.pop();
            }

            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()){
                sb.append(deque.pop());
            }


            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
    class Solution2 {

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
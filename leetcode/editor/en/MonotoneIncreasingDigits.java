//
//Given a non-negative integer N, find the largest number that is less than or e
//qual to N with monotone increasing digits.
// 
//(Recall that an integer has monotone increasing digits if and only if each pai
//r of adjacent digits x and y satisfy x <= y.)
// 
//
// Example 1: 
// 
//Input: N = 10
//Output: 9
// 
// 
//
// Example 2: 
// 
//Input: N = 1234
//Output: 1234
// 
// 
//
// Example 3: 
// 
//Input: N = 332
//Output: 299
// 
// 
//
// Note:
//N is an integer in the range [0, 10^9].
// Related Topics Greedy

  
package leetcode.editor.en;

public class MonotoneIncreasingDigits{
    public static void main(String[] args) {
         Solution solution = new MonotoneIncreasingDigits().new Solution();
         solution.monotoneIncreasingDigits(1232);
        solution.monotoneIncreasingDigits(5998796);
        solution.monotoneIncreasingDigits(10);
        solution.monotoneIncreasingDigits(332);
//        solution.monotoneIncreasingDigits(1232);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int monotoneIncreasingDigits(int N) {
        String n = String.valueOf(N);
        int x = n.length() , y = 0;

        for(int i = 1; i < n.length() ; i ++) {
            if(n.charAt(i) < n.charAt(i  - 1)) {
                    x = i - 1;
                    break;
                }
        }

        if( x == n.length()) {
            return N;
        }


        y = x;

        int t = Character.getNumericValue( n.charAt(x) ) - 1;
        while (
                y != 0 &&
                Character.getNumericValue( n.charAt(y - 1)) > t ) {
            y--;
            if(y == 0) break;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < y ; i ++) {
            sb.append(n.charAt(i));
        }
        sb.append( Character.getNumericValue( n.charAt(y) ) - 1);

        for (int i = y + 1; i < n.length() ; i ++) {
            sb.append(9);
        }

        return Integer.parseInt(sb.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}

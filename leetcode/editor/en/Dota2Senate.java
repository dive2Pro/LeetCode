package leetcode.editor.en;

//In the world of Dota2, there are two parties: the Radiant and the Dire.
//
// The Dota2 senate consists of senators coming from two parties. Now the senate
// wants to make a decision about a change in the Dota2 game. The voting for this 
//change is a round-based procedure. In each round, each senator can exercise one 
//of the two rights: 
//
// 
// Ban one senator's right: 
// A senator can make another senator lose all his rights in this and all the following rounds.
// Announce the victory: 
// If this senator found the senators who still have rights to vote are all from
// the same party, he can announce the victory and make the decision about the cha
//nge in the game. 
// 
//
// 
//
// Given a string representing each senator's party belonging. The character 'R'
// and 'D' represent the Radiant party and the Dire party respectively. Then if th
//ere are n senators, the size of the given string will be n. 
//
// The round-based procedure starts from the first senator to the last senator i
//n the given order. This procedure will last until the end of voting. All the senators
// who have lost their rights will be skipped during the procedure.
//
// Suppose every senator is smart enough and will play the best strategy for his
// own party, you need to predict which party will finally announce the victory an
//d make the change in the Dota2 game. The output should be Radiant or Dire. 
//
// Example 1: 
//
// 
//Input: "RD"
//Output: "Radiant"
//Explanation: The first senator comes from Radiant and he can just ban the next
// senator's right in the round 1. 
//And the second senator can't exercise any rights any more since his right has 
//been banned. 
//And in the round 2, the first senator can just announce the victory since he i
//s the only guy in the senate who can vote.
// 
//
// 
//
// Example 2: 
//
// 
//Input: "RDD"
//Output: "Dire"
//Explanation: 
//The first senator comes from Radiant and he can just ban the next senator's ri
//ght in the round 1. 
//And the second senator can't exercise any rights anymore since his right has b
//een banned. 
//And the third senator comes from Dire and he can ban the first senator's right
// in the round 1. 
//And in the round 2, the third senator can just announce the victory since he i
//s the only guy in the senate who can vote.
// 
//
// 
//
// Note: 
//
// 
// The length of the given string will in the range [1, 10,000]. 
// 
//
// 
// Related Topics Greedy 
// 👍 279 👎 211


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

public class Dota2Senate {
    public static void main(String[] args) {
        Solution solution = new Dota2Senate().new Solution();
        String result = solution.predictPartyVictory("RD");
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String predictPartyVictory(String senate) {
           // RD 在一轮过后的最优解
            // 前一个关闭后一个
            // 后一个发现自己被关了，把自己删掉

            int[] people = new int[] {0, 0};
            int[] delete = new int[] {0, 0};

            LinkedList<Integer> list = new LinkedList<>();
            for(char c : senate.toCharArray()) {
                int v = c == 'R' ? 1: 0;
                people[v] ++;
                list.add(v);
            }



            while (people[0] > 0 && people[1] > 0) {
                int v = list.poll();
                if(delete[v] > 0) {
                    delete[v] --;
                    people[v] --;
                } else {
                    delete[v^1] ++;
                    list.add(v);
                }
            }

            //In the world of Dota2, there are two parties: the Radiant and the Dire.
            return people[0] > 0 ? "Dire" : "Radiant";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
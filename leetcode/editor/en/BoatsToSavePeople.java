
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int end = people.length - 1;
        int start = 0;
        int res = 0;
        for(; start<= end; end --) {
            if(people[end] + people[start] > limit) {
                res ++;
            } else {
                start ++;                
                res ++;
            }
        }
        
        return res;
    }
}

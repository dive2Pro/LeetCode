[TOC]

---
#### Approach #1: Simulation [Accepted]

**Intuition**

A senator performing a ban doesn't need to use it on another senator immediately.  We can wait to see when another team's senator will vote, then use that ban retroactively.

**Algorithm**

Put the senators in an integer queue: `1` for `'Radiant'` and `0` for `'Dire'`.

Now process the queue: if there is a floating ban for that senator, exercise it and continue.  Otherwise, add a floating ban against the other team, and enqueue this senator again.

```
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> queue = new LinkedList();
        int[] people = new int[]{0, 0};
        int[] bans = new int[]{0, 0};

        for (char person: senate.toCharArray()) {
            int x = person == 'R' ? 1 : 0;
            people[x]++;
            queue.add(x);
        }

        while (people[0] > 0 && people[1] > 0) {
            int x = queue.poll();
            if (bans[x] > 0) {
                bans[x]--;
                people[x]--;
            } else {
                bans[x^1]++;
                queue.add(x);
            }
        }

        return people[1] > 0 ? "Radiant" : "Dire";
    }
}
```

**Complexity Analysis**

* Time Complexity: *O(N)* where *N* is the size of the senate.  Every vote removes one senator from the other team.

* Space Complexity: *O(N)*, the space used by our queue.
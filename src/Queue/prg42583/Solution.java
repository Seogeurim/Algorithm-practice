package Queue.prg42583;

import java.util.*;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<int[]> q = new LinkedList<>();
        int sum = 0, sec = 1, idx = 1;

        q.offer(new int[]{truck_weights[0], bridge_length+1});
        sum = truck_weights[0];

        while (!q.isEmpty()) {
            sec ++;
            if (q.peek()[1] == sec) {
                sum -= q.poll()[0];
            }
            if (idx < truck_weights.length && sum + truck_weights[idx] <= weight) {
                q.offer(new int[]{truck_weights[idx], sec+bridge_length});
                sum += truck_weights[idx];
                idx ++;
            }
        }

        return sec;
    }
}

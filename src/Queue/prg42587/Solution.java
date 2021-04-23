package Queue.prg42587;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        int N = priorities.length;
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) q.offer(i);

        int cnt = 0;
        while (!q.isEmpty()) {
            int J = q.removeFirst();
            boolean print = true;
            for (int i = 0; i < q.size(); i++) {
                if (priorities[J] < priorities[q.get(i)]) {
                    q.addLast(J);
                    print = false;
                    break;
                }
            }
            if (print) {
                cnt ++;
                if (J == location) return cnt;
            }
        }

        return N;
    }
}

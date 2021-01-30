package Queue.prg42628;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"I 16", "D 1"})));
        // [0, 0]
        System.out.println(Arrays.toString(sol.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        // [0, 0]
        System.out.println(Arrays.toString(sol.solution(new String[]{"I 7", "I 5", "I -5", "D -1"})));
        // [7, 5]
        System.out.println(Arrays.toString(sol.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
        // [333, -45]
    }
}

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            char cmd = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if (cmd == 'I') {
                pqMin.add(num);
                pqMax.add(num);
            } else if (cmd == 'D' && !pqMin.isEmpty()) {
                if (num == 1) {
                    int target = pqMax.poll();
                    pqMin.remove(target);
                } else if (num == -1) {
                    int target = pqMin.poll();
                    pqMax.remove(target);
                }
            }
        }

        if (pqMin.isEmpty()) return new int[]{0, 0};
        else return new int[]{pqMax.peek(), pqMin.peek()};
    }
}

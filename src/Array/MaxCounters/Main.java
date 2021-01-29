package Array.MaxCounters;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
        System.out.println(Arrays.toString(sol.solution(1, new int[]{2, 1})));
    }
}

class Solution {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0, max_cnt = 0;
        for (int a : A) {
            if (a > N) max_cnt = max;
            else {
                if (counters[a-1] < max_cnt) counters[a-1] = max_cnt;
                counters[a-1] ++;
                max = Math.max(max, counters[a-1]);
            }
        }

        for (int i = 0; i < N; i++) {
            if (counters[i] < max_cnt) counters[i] = max_cnt;
        }

        return counters;
    }
}
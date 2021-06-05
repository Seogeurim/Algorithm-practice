package TimeComplexity.prg43238;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(6, new int[]{7, 10}));
    }
}

class Solution {
    public long solution(int n, int[] times) {

        long low = 0, high = 0;

        for (int time : times) high = Math.max(high, time);
        high *= n;

        while (low < high) {
            long mid = (low + high) / 2, cnt = 0;
            for (int time : times) cnt += mid / time;

            if (cnt >= n) high = mid;
            else low = mid + 1;
        }

        return low;
    }
}

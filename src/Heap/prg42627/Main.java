package Heap.prg42627;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{{1, 9}, {2, 6}, {0, 3}}));
        System.out.println(sol.solution(new int[][]{{0, 3}, {3, 9}, {12, 6}}));
        System.out.println(sol.solution(new int[][]{{0, 10}, {0, 5}, {3, 9}, {12, 6}}));
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;

        Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));

        int ans = 0;
        int current = 0;
        int i = 0, count = 0;
        while (count < n) {
            while (i < n && jobs[i][0] <= current) {
                pq.add(jobs[i++]);
            }
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                ans += current - job[0] + job[1];
                current += job[1];
                count ++;
            } else {
                current = jobs[i][0];
            }
        }

        return ans / n;
    }
}
package DP.MinAbsSum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{}));
        System.out.println(sol.solution(new int[]{1, 5, 2, -2}));
        System.out.println(sol.solution(new int[]{3, 3, 3, 4, 5})); // 0
    }
}

class Solution {
    public int solution(int[] A) {
        if (A.length == 0) return 0;

        int[] dp = new int[A.length];
        dp[0] = Math.min(A[0], (-1) * A[0]);
        for (int i = 1; i < A.length; i++) {
            if (Math.abs(dp[i-1] + A[i]) < Math.abs(dp[i-1] - A[i])) {
                dp[i] = dp[i-1] + A[i];
            } else {
                dp[i] = dp[i-1] - A[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return Math.abs(dp[A.length - 1]);
    }
}

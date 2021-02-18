package Greedy.P2839;

import java.util.*;

public class usingDP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[5001];
        Arrays.fill(dp, 5000);

        dp[3] = 1;
        dp[5] = 1;
        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
        }

        if (dp[N] >= 5000) System.out.println(-1);
        else System.out.println(dp[N]);
    }
}

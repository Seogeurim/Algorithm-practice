package DP.P2193;

import java.util.Scanner;

public class Main {

    static int N;
    static long[][] dp = new long[91][2];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp[1][0] = 0; dp[1][1] = 1;
        dp[2][0] = 1; dp[2][1] = 0;

        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}

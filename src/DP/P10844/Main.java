package DP.P10844;

import java.util.Scanner;

public class Main {

    static int N;
    static long[][] dp = new long[101][10];
    static final int mod = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int l = 1; l <= 9; l++) dp[1][l] = 1;
        for (int i = 2; i <= N; i++) {
            for (int l = 1; l <= 8; l++)
                dp[i][l] = (dp[i-1][l-1] + dp[i-1][l+1]) % mod;
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[N][i];
            ans %= mod;
        }
        System.out.println(ans);
    }
}

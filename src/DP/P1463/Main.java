package DP.P1463;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 2; i <= N; i++) {
            int x1 = (i % 3 == 0) ? dp[i/3] : Integer.MAX_VALUE;
            int x2 = (i % 2 == 0) ? dp[i/2] : Integer.MAX_VALUE;
            int x3 = dp[i-1];
            dp[i] = Math.min(x1, Math.min(x2, x3)) + 1;
        }

        System.out.println(dp[N]);
    }
}

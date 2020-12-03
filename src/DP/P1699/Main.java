package DP.P1699;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] dp = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int nearSquare = (int) Math.floor(Math.sqrt(i));
            dp[i] = Integer.MAX_VALUE;
            for (int j = nearSquare; j > 0; j--) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}

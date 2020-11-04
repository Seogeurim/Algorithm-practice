package DP.P11057;

import java.util.Scanner;

public class Main {

    static int N;
    static int[][] dp = new int[1001][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < 10; i++) dp[1][i] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) sum += dp[N][i];

        System.out.println(sum % 10007);
    }
}

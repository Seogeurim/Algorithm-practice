package DP.P1149;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] cost, dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P1149/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) dp[i][j] = cost[i][j];
            }
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
}

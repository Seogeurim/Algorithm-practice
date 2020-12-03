package DP.P2225;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static long[][] dp = new long[201][201];
    final static int mod = 1000000000;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P2225/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= K; i++) dp[0][i] = 1;
        for (int i = 0; i <= N; i++) dp[i][1] = 1;

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[j][i] = (dp[j-1][i] + dp[j][i-1]) % mod;
            }
        }

        System.out.println(dp[N][K]);
    }
}

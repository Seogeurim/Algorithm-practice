package DP.P2098;

import java.io.*;
import java.util.*;

public class Main {

    static int INF = 160000000;
    static int N;
    static int[][] W, dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P2098/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[1<<N][N];
        for (int i = 0; i < 1 << N; i++) Arrays.fill(dp[i], INF);

        System.out.println(TSP(1, 0));
    }

    static int TSP(int mask, int now) {
        if (mask == (1<<N)-1) {
            if (W[now][0] > 0) return W[now][0];
            return INF;
        }

        if (dp[mask][now] != INF) return dp[mask][now];
        for (int i = 0; i < N; i++) {
            if ((mask & 1<<i) == 0 && W[now][i] > 0) {
                dp[mask][now] = Math.min(dp[mask][now], TSP(mask|1<<i, i) + W[now][i]);
            }
        }
        return dp[mask][now];
    }
}

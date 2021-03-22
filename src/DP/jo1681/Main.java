package DP.jo1681;

import java.io.*;
import java.util.*;

public class Main {

    final static int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] map, dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/jo1681/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[1<<N][N];
        for (int i = 0; i < 1 << N; i++) Arrays.fill(dp[i], INF);

        System.out.println(tsp(1, 0));
    }

    static int tsp(int mask, int now) {
        if (mask == (1<<N)-1) {
            if (map[now][0] > 0) return map[now][0];
            return INF;
        }

        if (dp[mask][now] != INF) return dp[mask][now];

        for (int i = 0; i < N; i++) {
            if ((mask & 1<<i) == 0 && map[now][i] != 0) {
                int ret = tsp(mask | 1<<i, i);
                if (ret == INF) continue;
                dp[mask][now] = Math.min(dp[mask][now], ret + map[now][i]);
            }
        }

        return dp[mask][now];
    }
}

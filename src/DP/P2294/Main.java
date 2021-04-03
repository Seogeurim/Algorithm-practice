package DP.P2294;

import java.io.*;
import java.util.*;

public class Main {

    final static int INF = Integer.MAX_VALUE;
    static int n, k;
    static int[] coins, dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P2294/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        dp = new int[k+1];
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins);

        for (int i = 1; i <= k; i++) {
            dp[i] = INF;
            for (int coin : coins) {
                if (coin > i) break;
                if (dp[i-coin] == INF) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }

        System.out.println(dp[k] == INF ? -1 : dp[k]);
    }
}

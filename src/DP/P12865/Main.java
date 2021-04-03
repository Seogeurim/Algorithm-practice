package DP.P12865;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K, W, V;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P12865/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], V + dp[j-W]);
            }
        }

        System.out.println(dp[K]);
    }
}

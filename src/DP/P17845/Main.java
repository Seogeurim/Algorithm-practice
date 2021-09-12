package DP.P17845;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K, I, T;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P17845/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            I = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            for (int j = N; j >= T; j--) {
                dp[j] = Math.max(dp[j], I + dp[j-T]);
            }
        }

        System.out.println(dp[N]);
    }
}

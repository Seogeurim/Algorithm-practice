package DP.P11066;

import java.io.*;
import java.util.*;

public class Main {

    static int T, K;
    static int[] files, sum;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P11066/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            K = Integer.parseInt(br.readLine());

            files = new int[K+1];
            sum = new int[K+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + files[i];
            }

            dp = new int[K+1][K+1];
            for (int depth = 1; depth < K; depth++) {
                for (int i = 1; i + depth <= K; i++) {
                    int j = i + depth;
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sum[j] - sum[i-1]);
                    }
                }
            }

            System.out.println(dp[1][K]);
        }
    }
}

package DP.P11722;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P11722/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        dp = new int[N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int maxLength = 0;
            for (int j = 0; j < N; j++) {
                if (A[j] > A[i]) {
                    maxLength = Math.max(maxLength, dp[j]);
                }
            }
            dp[i] = maxLength + 1;
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}

package DP.P11053;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A, dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P11053/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        dp = new int[N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int maxIdx = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    maxIdx = Math.max(maxIdx, dp[j]);
                }
            }
            dp[i] = maxIdx + 1;
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}

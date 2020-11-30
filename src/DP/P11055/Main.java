package DP.P11055;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P11055/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        dp = new int[N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + A[i];
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}

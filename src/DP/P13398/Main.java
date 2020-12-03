package DP.P13398;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P13398/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][2];
        dp[0][0] = dp[0][1] = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], 0) + arr[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + arr[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(max);
    }
}

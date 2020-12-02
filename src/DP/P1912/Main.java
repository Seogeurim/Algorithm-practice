package DP.P1912;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P1912/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
        dp[0] = arr[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1], 0) + arr[i];
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}

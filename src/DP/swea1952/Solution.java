package DP.swea1952;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int T;
    static int[] fare, plan, dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/swea1952/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            fare = new int[4];
            plan = new int[13];
            dp = new int[13];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) fare[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) plan[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= 12; i++) {
                dp[i] = dp[i-1] + Math.min(fare[0] * plan[i], fare[1]);
                if (i >= 3) dp[i] = Math.min(dp[i], dp[i-3] + fare[2]);
            }

            sb.append("#").append(t).append(" ").append(Math.min(dp[12], fare[3])).append("\n");
        }

        System.out.println(sb.toString());
    }
}

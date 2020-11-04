package DP.P2579;

import java.io.*;

public class Main {

    static int N;
    static int[] stairs = new int[301];
    static int[] dp = new int[301];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P2579/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) stairs[i] = Integer.parseInt(br.readLine());

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }

        System.out.println(dp[N]);
    }
}

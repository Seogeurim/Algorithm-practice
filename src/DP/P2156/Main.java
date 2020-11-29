package DP.P2156;

import java.io.*;

public class Main {

    static int n;
    static int[] drink;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P2156/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        drink = new int[n+1];
        dp = new long[n+1];
        for (int i = 1; i <= n; i++)
            drink[i] = Integer.parseInt(br.readLine());

        dp[1] = drink[1];
        if (n > 1) {
            dp[2] = drink[1] + drink[2];
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i-2] + drink[i], dp[i-3] + drink[i-1] + drink[i]);
                dp[i] = Math.max(dp[i-1], dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}

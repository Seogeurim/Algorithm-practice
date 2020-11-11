package DP.P9095;

import java.io.*;

public class Main {

    static int T, n;
    static int[] dp = new int[11];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P9095/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            System.out.println(dp[n]);
        }
    }
}

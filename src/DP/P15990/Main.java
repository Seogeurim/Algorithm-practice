package DP.P15990;

import java.io.*;

public class Main {

    static int T, n;
    static long[][] dp = new long[100001][4];
    static final int mod = 1000000009;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P15990/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        dp[1][1] = 1; dp[1][2] = 0; dp[1][3] = 0;
        dp[2][1] = 0; dp[2][2] = 1; dp[2][3] = 0;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= n; i++) {
                dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod;
                dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % mod;
                dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % mod;
            }
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % mod);
        }
    }
}

package DP.P1328;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static int MOD = 1000000007;
    static int N, L, R;
    static long[][][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P1328/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        dp = new long[N+1][N+1][N+1];
        dp[1][1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    dp[i][j][k] = (dp[i-1][j-1][k] + dp[i-1][j][k-1] + dp[i-1][j][k]*(i-2)) % MOD;
                }
            }
        }

        System.out.println(dp[N][L][R]);
    }
}

package DP.swea1861;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static int[][] map, dp;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/swea1861/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int num = 0, max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dfs(i, j);
                    if (max < dp[i][j] || (max == dp[i][j] && num > map[i][j])) {
                        num = map[i][j];
                        max = dp[i][j];
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(num).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int dfs(int i, int j) {
        if (dp[i][j] > 0) return dp[i][j];

        dp[i][j] = 1;
        for (int d = 0; d < 4; d++) {
            int to_i = i + di[d];
            int to_j = j + dj[d];

            if (isValidPath(to_i, to_j) && map[to_i][to_j] == map[i][j] + 1) {
                dp[i][j] = dfs(to_i, to_j) + 1;
            }
        }

        return dp[i][j];
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}

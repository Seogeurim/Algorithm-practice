package BFS.swea1249;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static int[][] map, dp;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/swea1249/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();
            sb.append("#").append(t).append(" ").append(dp[N-1][N-1]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0, 0));
        dp[0][0] = 0;
        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int k = 0; k < 4; k++) {
                int to_i = p.i + di[k];
                int to_j = p.j + dj[k];

                if (isValidPath(to_i, to_j) && dp[to_i][to_j] > dp[p.i][p.j] + map[to_i][to_j]) {
                    dp[to_i][to_j] = dp[p.i][p.j] + map[to_i][to_j];
                    q.offer(new Pos(to_i, to_j));
                }
            }
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

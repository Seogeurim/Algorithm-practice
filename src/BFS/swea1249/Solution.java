package BFS.swea1249;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static int[][] map, dist;
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
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();
            sb.append("#").append(t).append(" ").append(dist[N-1][N-1]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(new Pos(0, 0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Pos p = q.poll();
            if (p.i == N-1 && p.j == N-1) {
                dist[N-1][N-1] = Math.min(dist[N-1][N-1], p.dist);
                continue;
            }

            for (int k = 0; k < 4; k++) {
                int to_i = p.i + di[k];
                int to_j = p.j + dj[k];

                if (!isValidPath(to_i, to_j)) continue;
                int to_d = p.dist + map[to_i][to_j];
                if (!visited[to_i][to_j] || to_d < dist[to_i][to_j]) {
                    visited[to_i][to_j] = true;
                    dist[to_i][to_j] = to_d;
                    q.offer(new Pos(to_i, to_j, to_d));
                }
            }
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }

    static class Pos {
        int i, j, dist;

        public Pos(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
}

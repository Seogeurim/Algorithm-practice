package BFS.swea1249;

import java.io.*;
import java.util.*;

public class Solution2 {

    static int T, N;
    static int[][] map;
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
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) map[i][j] = line.charAt(j) - '0';
            }
            sb.append("#").append(t).append(" ").append(bfs()).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int bfs() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];

        pq.offer(new Pos(0, 0, 0));
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            Pos p = pq.poll();
            if (p.i == N-1 && p.j == N-1) return p.d;

            for (int k = 0; k < 4; k++) {
                int to_i = p.i + di[k];
                int to_j = p.j + dj[k];

                if (isValidPath(to_i, to_j) && !visited[to_i][to_j]) {
                    visited[to_i][to_j] = true;
                    pq.offer(new Pos(to_i, to_j, p.d + map[to_i][to_j]));
                }
            }
        }

        return 0;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }

    static class Pos implements Comparable<Pos> {
        int i, j, d;

        public Pos(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }

        @Override
        public int compareTo(Pos o) {
            return d - o.d;
        }
    }
}

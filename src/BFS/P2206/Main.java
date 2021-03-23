package BFS.P2206;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P2206/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Pos> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];

        q.offer(new Pos(0, 0, 1, 1));
        visited[0][0][1] = true;
        while (!q.isEmpty()) {
            Pos p = q.poll();
            if (p.i == N-1 && p.j == M-1) return p.dist;

            for (int k = 0; k < 4; k++) {
                int to_i = p.i + di[k];
                int to_j = p.j + dj[k];

                if (!isValidPath(to_i, to_j)) continue;
                if (map[to_i][to_j] == '0' && !visited[to_i][to_j][p.wall]) {
                    visited[to_i][to_j][p.wall] = true;
                    q.offer(new Pos(to_i, to_j, p.dist+1, p.wall));
                } else if (p.wall > 0) {
                    visited[to_i][to_j][0] = true;
                    q.offer(new Pos(to_i, to_j, p.dist+1, p.wall-1));
                }
            }
        }

        return -1;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }

    static class Pos {
        int i, j, dist, wall;

        public Pos(int i, int j, int dist, int wall) {
            this.i = i;
            this.j = j;
            this.dist = dist;
            this.wall = wall;
        }
    }
}

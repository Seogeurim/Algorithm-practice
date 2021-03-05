package BFS.P1600;

import java.io.*;
import java.util.*;

public class Main {

    static int K, W, H;
    static int[][] map;

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] horse = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {2, 1}, {1, 2}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P1600/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Position> q = new LinkedList<>();
        boolean[][][] visited = new boolean[H][W][K+1];

        q.offer(new Position(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Position p = q.poll();
            if (p.i == H-1 && p.j == W-1) return p.cnt;

            for (int t = 0; t < 4; t++) {
                int to_i = p.i + delta[t][0];
                int to_j = p.j + delta[t][1];

                if (isValidPath(to_i, to_j) && map[to_i][to_j] == 0 && !visited[to_i][to_j][p.k]) {
                    visited[to_i][to_j][p.k] = true;
                    q.offer(new Position(to_i, to_j, p.k, p.cnt+1));
                }
            }

            if (p.k == K) continue;
            for (int t = 0; t < 8; t++) {
                int to_i = p.i + horse[t][0];
                int to_j = p.j + horse[t][1];

                if (isValidPath(to_i, to_j) && map[to_i][to_j] == 0 && !visited[to_i][to_j][p.k+1]) {
                    visited[to_i][to_j][p.k+1] = true;
                    q.offer(new Position(to_i, to_j, p.k+1, p.cnt+1));
                }
            }
        }

        return -1;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < H && 0 <= j && j < W;
    }

    static class Position {
        int i, j, k, cnt;

        public Position(int i, int j, int k, int cnt) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.cnt = cnt;
        }
    }
}

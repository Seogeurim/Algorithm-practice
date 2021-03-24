package BFS.P1600;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    static int K, W, H;
    static int[][] map;

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] horse = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

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
        Queue<Pos> q = new LinkedList<>();
        boolean[][][] visited = new boolean[H][W][K+1];

        q.offer(new Pos(0, 0, K, 0));
        visited[0][0][K] = true;
        while (!q.isEmpty()) {
            Pos p = q.poll();
            if (p.i == H-1 && p.j == W-1) return p.dist;

            for (int k = 0; k < 4; k++) {
                int to_i = p.i + delta[k][0];
                int to_j = p.j + delta[k][1];

                if (isValidPath(to_i, to_j) && map[to_i][to_j] == 0 && !visited[to_i][to_j][p.k]) {
                    visited[to_i][to_j][p.k] = true;
                    q.offer(new Pos(to_i, to_j, p.k, p.dist+1));
                }
            }
            if (p.k == 0) continue;
            for (int k = 0; k < 8; k++) {
                int to_i = p.i + horse[k][0];
                int to_j = p.j + horse[k][1];

                if (isValidPath(to_i, to_j) && map[to_i][to_j] == 0 && !visited[to_i][to_j][p.k-1]) {
                    visited[to_i][to_j][p.k-1] = true;
                    q.offer(new Pos(to_i, to_j, p.k-1, p.dist+1));
                }
            }
        }

        return -1;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < H && 0 <= j && j < W;
    }

    static class Pos {
        int i, j, k, dist;

        public Pos(int i, int j, int k, int dist) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.dist = dist;
        }
    }
}

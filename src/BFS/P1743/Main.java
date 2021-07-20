package BFS.P1743;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, r, c, max = 0;
    static int[][] map;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P1743/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) max = Math.max(max, bfs(i, j));
            }
        }

        System.out.println(max);
    }

    static int bfs(int i, int j) {
        Queue<Pos> q= new LinkedList<>();
        q.offer(new Pos(i, j));
        map[i][j] = 0;
        int cnt = 1;
        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int k = 0; k < 4; k++) {
                int ti = p.i + di[k];
                int tj = p.j + dj[k];
                if (0 <= ti && ti < N && 0 <= tj && tj < M && map[ti][tj] == 1) {
                    map[ti][tj] = 0;
                    q.offer(new Pos(ti, tj));
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

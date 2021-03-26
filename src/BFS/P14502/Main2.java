package BFS.P14502;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, M, ans;
    static int[][] map;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static Queue<Pos> q = new LinkedList<>();
    static ArrayList<Pos> wall = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P14502/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) q.offer(new Pos(i, j));
                else if (map[i][j] == 0) wall.add(new Pos(i, j));
            }
        }

        comb(0, 0);
        System.out.println(ans);
    }

    static void comb(int start, int cnt) {
        if (cnt == 3) {
            ans = Math.max(ans, virus());
            return;
        }

        for (int i = start, size = wall.size(); i < size; i++) {
            Pos p = wall.get(i);
            map[p.i][p.j] = 1;
            comb(i+1, cnt+1);
            map[p.i][p.j] = 0;
        }
    }

    static int virus() {
        boolean[][] visited = new boolean[N][M];

        while (!q.isEmpty()) {
            Pos p = q.poll();

            for (int k = 0; k < 4; k++) {
                int ni = p.i + di[k];
                int nj = p.j + dj[k];

                if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
                if (!visited[ni][nj] && map[ni][nj] == 0) {
                    visited[ni][nj] = true;
                    q.offer(new Pos(ni, nj));
                }
            }
        }

        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) safe ++;
                if (map[i][j] == 2) q.offer(new Pos(i, j));
            }
        }

        return safe;
    }

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

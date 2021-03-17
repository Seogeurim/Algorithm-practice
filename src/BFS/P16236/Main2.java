package BFS.P16236;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, ans;
    static int[][] map;
    static Pos from, to;
    static int[] di = {-1, 0, 0, 1};
    static int[] dj = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P16236/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    from = new Pos(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        int size = 2, eat = 0;
        while ( (to = bfs(size)) != null ) {
            if (size == ++eat) { size ++; eat = 0; }
            ans += to.time;
            from = new Pos(to.i, to.j, 0);
        }

        System.out.println(ans);
    }

    static Pos bfs(int size) {
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(new Pos(from.i, from.j, 0));
        visited[from.i][from.j] = true;
        Pos min = null;
        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int k = 0; k < 4; k++) {
                int to_i = p.i + di[k];
                int to_j = p.j + dj[k];

                if (isValidPath(to_i, to_j) && !visited[to_i][to_j] && map[to_i][to_j] <= size) {
                    visited[to_i][to_j] = true;
                    Pos to = new Pos(to_i, to_j, p.time+1);
                    if (0 < map[to_i][to_j] && map[to_i][to_j] < size) {
                        if (min == null) min = to;
                        else min = compare(min, to);
                    } else q.offer(to);
                }
            }
        }

        if (min != null) map[min.i][min.j] = 0;
        return min;
    }

    static Pos compare(Pos a, Pos b) {
        if (a.time < b.time) return a;
        else if (a.time > b.time) return b;
        else {
            if (a.i < b.i) return a;
            else if (a.i > b.i) return b;
            else {
                if (a.j < b.j) return a;
                else return b;
            }
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }

    static class Pos {
        int i, j, time;

        public Pos(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
}

package Simulation.P15683;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans;
    static int[][] map;
    static Pos[] cctvs = new Pos[9];
    static int[][] delta = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 우상좌하

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P15683/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0, k = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) ans ++;
                else if (1 <= map[i][j] && map[i][j] <= 5) cctvs[k++] = new Pos(map[i][j], i, j);
            }
        }

        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int cnt) {
        if (cctvs[cnt] == null) {
            int size = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) size ++;
                }
            }
            ans = Math.min(ans, size);
            return;
        }

        for (int k = 0; k < 4; k++) {
            visit(cctvs[cnt], k, 9);
            dfs(cnt+1);
            visit(cctvs[cnt], k, -9);
        }
    }

    static void visit(Pos p, int r, int state) {
        if (p.n == 2) {
            if (r == 0 || r == 2) { go(p, 0, state); go(p, 2, state); }
            else { go(p, 1, state); go(p, 3, state); }
        } else {
            go(p, r, state);
            if (p.n >= 3) go(p, (r+1)%4, state);
            if (p.n >= 4) go(p, (r+2)%4, state);
            if (p.n == 5) go(p, (r+3)%4, state);
        }
    }

    static void go(Pos p, int d, int state) {
        int i = p.i + delta[d][0], j = p.j + delta[d][1];
        while (isValidPath(i, j) && map[i][j] != 6) {
            if (map[i][j] == 0 || map[i][j] >= 9) map[i][j] += state;
            i += delta[d][0];
            j += delta[d][1];
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }

    static class Pos {
        int n, i, j;

        public Pos(int n, int i, int j) {
            this.n = n;
            this.i = i;
            this.j = j;
        }
    }
}

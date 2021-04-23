package Simulation.P15686;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, ans = Integer.MAX_VALUE;
    static int[][] map;
    static List<Pos> home, chicken;
    static int[] selected;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P15686/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) home.add(new Pos(i, j));
                else if (map[i][j] == 2) chicken.add(new Pos(i, j));
            }
        }

        selected = new int[M];
        dfs(0, 0);

        System.out.println(ans);
    }

    static void dfs(int start, int cnt) {
        if (cnt == M) {
            int sum = 0;
            for (Pos h : home) {
                int dist = Integer.MAX_VALUE;
                for (int s : selected) {
                    Pos c = chicken.get(s);
                    dist = Math.min(dist, Math.abs(h.i - c.i) + Math.abs(h.j - c.j));
                }
                sum += dist;
            }
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = start, size = chicken.size(); i < size; i++) {
            selected[cnt] = i;
            dfs(i+1, cnt+1);
        }
    }

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

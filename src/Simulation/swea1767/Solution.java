package Simulation.swea1767;

import java.io.*;
import java.util.*;

class Solution {

    static int T, N, core, ans;
    static int[][] map;
    static ArrayList<int[]> list;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/swea1767/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && i != 0 && j != 0 && i != N-1 && j != N-1) {
                        list.add(new int[] {i, j});
                    }
                }
            }

            core = 0;
            ans = 0;
            dfs(0, 0, 0);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int idx, int cnt, int dist) {

        if (idx == list.size()) {
            if (core < cnt) {
                core = cnt;
                ans = dist;
            } else if (core == cnt) {
                ans = Math.min(ans, dist);
            }

            return;
        }

        int i = list.get(idx)[0], j = list.get(idx)[1];
        for (int k = 0; k < 4; k++) {
            int res = find(i, j, k);
            if (res == 0) continue;
            dfs(idx+1, cnt+1, dist+res);
            back(i, j, k);
        }
        dfs(idx+1, cnt, dist);
    }

    static void back(int i, int j, int d) {
        int to_i = i + di[d], to_j = j + dj[d];
        while (isValidPath(to_i, to_j) && map[to_i][to_j] == 2) {
            map[to_i][to_j] = 0;
            to_i += di[d];
            to_j += dj[d];
        }
    }

    static int find(int i, int j, int d) {

        int dist = 0;
        int to_i = i + di[d], to_j = j + dj[d];
        while (isValidPath(to_i, to_j) && map[to_i][to_j] == 0) {
            map[to_i][to_j] = 2;
            dist ++;

            if (to_i == 0 || to_j == 0 || to_i == N-1 || to_j == N-1) return dist;

            to_i += di[d];
            to_j += dj[d];
        }

        to_i -= di[d];
        to_j -= dj[d];
        while (true) {
            if (to_i == i && to_j == j) break;
            map[to_i][to_j] = 0;
            to_i -= di[d];
            to_j -= dj[d];
        }

        return 0;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}

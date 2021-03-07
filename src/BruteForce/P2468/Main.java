package BruteForce.P2468;

import java.io.*;
import java.util.*;

public class Main {

    static int N, ans;
    static int[][] map;
    static HashSet<Integer> set = new HashSet<>();

    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BruteForce/P2468/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                set.add(map[i][j]);
            }
        }

        set.add(0);
        for (int n : set) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > n && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j, n);
                        cnt ++;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }

    static void dfs(int i, int j, int n) {
        for (int t = 0; t < 4; t++) {
            int to_i = i + di[t];
            int to_j = j + dj[t];

            if (isValidPath(to_i, to_j) && !visited[to_i][to_j] && map[to_i][to_j] > n) {
                visited[to_i][to_j] = true;
                dfs(to_i, to_j, n);
            }
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}

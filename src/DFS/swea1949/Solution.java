package DFS.swea1949;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, K, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/swea1949/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];
            int max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) dfs(i, j, 1, 1);
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int i, int j, int cnt, int dist) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int to_i = i + di[k];
            int to_j = j + dj[k];

            if (isValidPath(to_i, to_j) && !visited[to_i][to_j]) {
                if (map[to_i][to_j] < map[i][j]) {
                    dfs(to_i, to_j, cnt, dist + 1);
                } else if (cnt > 0 && map[to_i][to_j]-K < map[i][j]) {
                    int tmp = map[to_i][to_j];
                    map[to_i][to_j] = map[i][j]-1;
                    dfs(to_i, to_j, cnt-1, dist + 1);
                    map[to_i][to_j] = tmp;
                } else {
                    ans = Math.max(ans, dist);
                }
            }
        }
        visited[i][j] = false;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}

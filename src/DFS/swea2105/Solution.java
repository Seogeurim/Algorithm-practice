package DFS.swea2105;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, ans;
    static int[][] map;
    static boolean[] eat;

    static int[] di = {1, 1, -1, -1};
    static int[] dj = {1, -1, -1, 1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/swea2105/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            ans = -1;
            eat = new boolean[101];
            for (int i = 0; i < N-2; i++) {
                for (int j = 1; j < N-1; j++) {
                    eat[map[i][j]] = true;
                    dfs(i, j, i, j,0, 1);
                    eat[map[i][j]] = false;
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int si, int sj, int i, int j, int dir, int sum) {
        for (int d = dir; d <= dir+1; d++) {
            if (d > 3) continue;
            int to_i = i + di[d];
            int to_j = j + dj[d];

            if (si == to_i && sj == to_j) {
                ans = Math.max(ans, sum);
                return;
            }

            if (isValidPath(to_i, to_j) && !eat[map[to_i][to_j]]) {
                eat[map[to_i][to_j]] = true;
                dfs(si, sj, to_i, to_j, d, sum+1);
                eat[map[to_i][to_j]] = false;
            }
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}

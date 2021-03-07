package DFS.P1937;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[][] map, dp;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P1937/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                K = Math.max(K, dfs(i, j));
            }
        }

        System.out.println(K);
    }

    static int dfs(int i, int j) {
        if (dp[i][j] > 1) return dp[i][j];

        dp[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int to_i = i + di[k];
            int to_j = j + dj[k];

            if (isValidPath(to_i, to_j) && map[i][j] < map[to_i][to_j]) {
                dp[i][j] = Math.max(dp[i][j], dfs(to_i, to_j)+1);
            }
        }

        return dp[i][j];
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}

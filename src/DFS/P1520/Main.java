package DFS.P1520;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static int M, N;
    static int[][] map, dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P1520/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int i, int j) {
        if (i == M-1 && j == N-1) return 1;

        if (dp[i][j] == -1) {
            dp[i][j] = 0;
            for (int k = 0; k < 4; k++) {
                int to_i = i + di[k];
                int to_j = j + dj[k];

                if (isValidPath(to_i, to_j) && map[i][j] > map[to_i][to_j]) {
                    dp[i][j] += dfs(to_i, to_j);
                }
            }
        }

        return dp[i][j];
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < M && 0 <= j && j < N;
    }
}

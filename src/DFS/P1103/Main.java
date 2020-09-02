package DFS.P1103;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static int[][] dp;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/DFS/P1103/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                dp[i][j] = -1;
            }
        }

        int ans = dfs(0, 0) + 1;
        System.out.println(ans);
    }

    static int dfs(int start_i, int start_j) {
        if (visited[start_i][start_j]) {
            System.out.println(-1);
            System.exit(0);
        }

        if (dp[start_i][start_j] != -1) return dp[start_i][start_j];

        visited[start_i][start_j] = true;
        dp[start_i][start_j] = 0;

        int num = board[start_i][start_j] - '0';
        for (int t = 0; t < 4; t++) {
            int to_i = start_i + di[t] * num;
            int to_j = start_j + dj[t] * num;

            if (isValidPath(to_i, to_j)) {
                dp[start_i][start_j] = Math.max(dp[start_i][start_j], dfs(to_i, to_j) + 1);
            }
        }

        visited[start_i][start_j] = false;
        return dp[start_i][start_j];
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M && board[i][j] != 'H';
    }
}

package DFS.P14500;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;

    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P14500/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                makeFuck(i, j);
                dfs(i, j, 0, 0);
            }
        }

        System.out.println(ans);
    }

    static void makeFuck(int i, int j) {
        int min = Integer.MAX_VALUE;
        int sum = board[i][j];
        int count = 0;

        for (int t = 0; t < 4; t++) {
            int to_i = i + di[t];
            int to_j = j + dj[t];

            if (isValidPath(to_i, to_j)) {
                min = Math.min(min, board[to_i][to_j]);
                sum += board[to_i][to_j];
                count ++;
            }
        }

        if (count == 3) ans = Math.max(ans, sum);
        else if (count == 4) ans = Math.max(ans, sum - min);
    }

    static void dfs(int si, int sj, int count, int sum) {
        if (count == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        visited[si][sj] = true;
        for (int i = 0; i < 4; i++) {
            int to_i = si + di[i];
            int to_j = sj + dj[i];

            if (isValidPath(to_i, to_j) && !visited[to_i][to_j]) {
                dfs(to_i, to_j, count+1, sum + board[si][sj]);
            }
        }
        visited[si][sj] = false;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}

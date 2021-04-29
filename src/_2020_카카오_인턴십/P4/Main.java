package _2020_카카오_인턴십.P4;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
        System.out.println(sol.solution(new int[][]{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}));
        System.out.println(sol.solution(new int[][]{{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}}));
        System.out.println(sol.solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}));
    }
}

class Solution {

    int N;
    int[] di = {-1, 0, 1, 0}, dj = {0, 1, 0, -1};
    int[][] board, dp;

    public int solution(int[][] board) {

        N = board.length;
        this.board = board;
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;
        for (int d = 1; d <= 2; d++) dfs(0, 0, d);

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (dp[i][j] == Integer.MAX_VALUE) System.out.print("INF ");
//                else System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        return dp[N-1][N-1];
    }

    void dfs(int i, int j, int d) {
        if (i == N-1 && j == N-1) return;

        for (int k = 0; k < 4; k++) {
            int to_i = i + di[k];
            int to_j = j + dj[k];

            int plus = d == k ? 100 : 600;
            if (isValidPath(to_i, to_j) && board[to_i][to_j] == 0 && dp[to_i][to_j] >= dp[i][j]+plus) {
//                System.out.println(i + " " + j + " | to: " + to_i + " " + to_j + " | d : " + d + " k : " + k + " | cost : " + (dp[i][j]+plus));
                dp[to_i][to_j] = dp[i][j]+plus;
                dfs(to_i, to_j, k);
            }
        }
    }

    boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}
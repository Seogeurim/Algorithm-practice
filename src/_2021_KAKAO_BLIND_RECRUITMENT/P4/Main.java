package _2021_KAKAO_BLIND_RECRUITMENT.P4;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(6, 4, 6, 2,
                new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
        System.out.println(sol.solution(7, 3, 4, 1,
                new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
        System.out.println(sol.solution(6, 4, 5, 6,
                new int[][]{{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}}));
    }
}

class Solution {

    final static int INF = Integer.MAX_VALUE;
    static int[][] D;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        D = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) D[i][j] = INF;
            }
        }

        for (int[] fare : fares) {
            int c = fare[0], d = fare[1], f = fare[2];
            D[c][d] = f;
            D[d][c] = f;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (D[i][k] == INF || D[k][j] == INF) continue;
                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }

        int ans = D[s][a] + D[s][b];
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, D[s][i] + D[i][a] + D[i][b]);
        }

        return ans;
    }
}
package Graph.prg49191;

class Solution {

    int[][] graph;

    public int solution(int n, int[][] results) {

        graph = new int[n+1][n+1];
        for (int[] res : results) {
            graph[res[0]][res[1]] = 1;
        } // graph[A][B] == 1 : A는 B를 이겼다.

        for (int i = 1; i <= n; i++) {
            graph[i][0] = -1;
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, n);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[0][j] += graph[i][j];
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (graph[0][i] + graph[i][0] == n-1) ans ++;
        }

        return ans;
    }

    void dfs(int cur, int n) {

        for (int i = 1; i <= n; i++) {
            if (graph[cur][i] == 1) {
                if (graph[i][0] == -1) dfs(i, n);
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] == 1) graph[cur][j] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += graph[cur][i];
        }
        graph[cur][0] = cnt;
    }
}

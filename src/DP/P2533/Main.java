package DP.P2533;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P2533/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N+1];
        dp = new int[N+1][2];
        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int idx) {
        visited[idx] = true;
        dp[idx][0] = 0;
        dp[idx][1] = 1;

        for (int next : graph[idx]) {
            if (visited[next]) continue;
            dfs(next);
            dp[idx][0] += dp[next][1];
            dp[idx][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}

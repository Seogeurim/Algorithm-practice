package Graph.P11724;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P11724/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                ans ++;
            }
        }

        System.out.println(ans);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int i = 0; i < graph[node].size(); i++) {
            int target = graph[node].get(i);
            if (!visited[target]) {
                dfs(target);
            }
        }
    }
}

package DFSandBFS.P1260;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static LinkedList<Integer>[] graph;

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFSandBFS/P1260/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken()) - 1;
            graph[f].add(t);
            graph[t].add(f);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N];
        dfs(V-1);

        System.out.println("");
        visited = new boolean[N];
        bfs(V-1);
    }

    static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + 1 + " ");

        for (int i = 0; i < graph[start].size(); i++) {
            int target = graph[start].get(i);
            if (!visited[target])
                dfs(target);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int target = q.poll();
            System.out.print(target + 1 + " ");

            for (int i = 0; i < graph[target].size(); i++) {
                int next = graph[target].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
package Graph.P1738;

import java.io.*;
import java.util.*;

public class Main {

    final static int INF = Integer.MAX_VALUE;
    static int n, m, u, v, w;
    static Edge[] edges;
    static List<Integer>[] rev;
    static int[] D, prev;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P1738/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new Edge[m];
        rev = new List[n+1];
        D = new int[n+1];
        prev = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            rev[i] = new ArrayList<>();
            D[i] = i == 1 ? 0 : INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, w*(-1));
            rev[v].add(u);
        }

        bfs();
        if (!bellmanFord()) System.out.println(-1);
        else {
            List<Integer> ans = new ArrayList<>();
            int cur = n;
            while (true) {
                ans.add(cur);
                if (cur == 1) break;
                else cur = prev[cur];
            }
            for (int i = ans.size()-1; i >= 0; i--) System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
    
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : rev[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

    static boolean bellmanFord() {
        for (int i = 1; i <= n; i++) {
            for (Edge e : edges) {
                int from = e.u, to = e.v, w = e.w;
                if (D[from] != INF && D[to] > D[from] + w) {
                    if (i == n && visited[to]) return false;
                    D[to] = D[from] + w;
                    prev[to] = from;
                }
            }
        }
        return true;
    }

    static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}

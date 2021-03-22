package Graph.P1753;

import java.io.*;
import java.util.*;

public class Main2 {

    final static int INF = Integer.MAX_VALUE;
    static int V, E, start;
    static int[] D;
    static LinkedList<Edge>[] graph;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P1753/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        graph = new LinkedList[V+1];
        for (int i = 1; i <= V; i++) graph[i] = new LinkedList<>();
        while(E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        D = new int[V+1];
        Arrays.fill(D, INF);
        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (D[i] == INF) System.out.println("INF");
            else System.out.println(D[i]);
        }
    }

    static void dijkstra() {
        D[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(((o1, o2) -> o1.w - o2.w));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (D[e.v] < e.w) continue;
            for (Edge to : graph[e.v]) {
                int dist = e.w + to.w;
                if (D[to.v] > dist) {
                    D[to.v] = dist;
                    pq.add(new Edge(to.v, dist));
                }
            }
        }
    }

    static class Edge {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}

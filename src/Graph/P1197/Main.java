package Graph.P1197;

import java.io.*;
import java.util.*;

public class Main {

    static int V, E, A, B, C;
    static PriorityQueue<Edge> pq = new PriorityQueue<>(((o1, o2) -> o1.c - o2.c));
    static int[] root;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P1197/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(A, B, C));
        }

        root = new int[V+1];
        for (int i = 1; i <= V; i++) root[i] = i;

        int cost = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (find(e.a) == find(e.b)) continue;
            merge(e.a, e.b);
            cost += e.c;
        }

        System.out.println(cost);
    }

    static int find(int n) {
        if (root[n] == n) return n;
        return root[n] = find(root[n]);
    }

    static void merge(int a, int b) {
        root[find(b)] = find(a);
    }

    static class Edge {
        int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}

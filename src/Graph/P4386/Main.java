package Graph.P4386;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] root;
    static double cost;
    static Node[] nodes;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P4386/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            nodes[i] = new Node(x, y);
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                Node n1 = nodes[i], n2 = nodes[j];
                double cost = Math.sqrt(Math.pow(Math.abs(n1.x - n2.x), 2) + Math.pow(Math.abs(n1.y - n2.y), 2));
                pq.offer(new Edge(i, j, cost));
            }
        }

        root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (find(e.from) == find(e.to)) continue;
            merge(e.from, e.to);
            cost += e.cost;
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

    static class Node {
        double x, y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to;
        double cost;

        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }
}

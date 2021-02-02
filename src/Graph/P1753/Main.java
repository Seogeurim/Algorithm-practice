package Graph.P1753;

import java.io.*;
import java.util.*;

public class Main {

    final static int INF = Integer.MAX_VALUE;
    static int V, E, K;
    static ArrayList<Node>[] graph;
    static int[] D;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P1753/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = stoi(st.nextToken());
        E = stoi(st.nextToken());
        K = stoi(br.readLine());

        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken()), v = stoi(st.nextToken()), w = stoi(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        D = new int[V+1];
        Arrays.fill(D, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.dist - o2.dist));

        pq.offer(new Node(K, 0));
        D[K] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (D[current.idx] < current.dist) continue;
            for (int i = 0; i < graph[current.idx].size(); i++) {
                Node next = graph[current.idx].get(i);
                if (D[next.idx] > D[current.idx] + next.dist) {
                    D[next.idx] = D[current.idx] + next.dist;
                    pq.offer(new Node(next.idx, D[next.idx]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (D[i] == INF) System.out.println("INF");
            else System.out.println(D[i]);
        }
    }

    private static int stoi(String s) { return Integer.parseInt(s); }

    static class Node {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}

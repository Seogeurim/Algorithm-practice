package Graph.P5719;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, S, D, U, V, P;
    static ArrayList<Node>[] graph, reverse;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P5719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while ((N = stoi(st.nextToken())) != 0 && (M = stoi(st.nextToken())) != 0) {
            st = new StringTokenizer(br.readLine());
            S = stoi(st.nextToken()); D = stoi(st.nextToken());

            graph = new ArrayList[N];
            reverse = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                reverse[i] = new ArrayList<>();
            }

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                U = stoi(st.nextToken()); V = stoi(st.nextToken()); P = stoi(st.nextToken());
                graph[U].add(new Node(V, P));
                reverse[V].add(new Node(U, P));
            }

            dijkstra();
            delPath();
            dijkstra();
            System.out.println(dist[D]);

            st = new StringTokenizer(br.readLine());
        }
    }

    static void dijkstra() {
        dist = new int[N];
        Arrays.fill(dist, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.dist - o2.dist));
        pq.offer(new Node(S, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.idx] != -1) continue;

            dist[cur.idx] = cur.dist;
            for (Node next : graph[cur.idx]) {
                if (dist[next.idx] == -1)
                    pq.offer(new Node(next.idx, dist[cur.idx] + next.dist));
            }
        }
    }

    static void delPath() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.offer(D); visited[D] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Node prev : reverse[cur]) {
                if (dist[prev.idx] + prev.dist == dist[cur]) {
                    graph[prev.idx].remove(new Node(cur, prev.dist));
                    if (!visited[prev.idx]) {
                        visited[prev.idx] = true;
                        q.offer(prev.idx);
                    }
                }
            }
        }
    }

    static int stoi(String s) { return Integer.parseInt(s); }

    static class Node {
        int idx, dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return idx == node.idx && dist == node.dist;
        }
    }
}

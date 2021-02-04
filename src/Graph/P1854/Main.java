package Graph.P1854;

import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Integer>[] D;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P1854/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        k = stoi(st.nextToken());

        graph = new ArrayList[n+1];
        D = new PriorityQueue[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            D[i] = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken()), b = stoi(st.nextToken()), c = stoi(st.nextToken());
            graph[a].add(new Node(b, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.dist - o2.dist));
        pq.offer(new Node(1, 0));
        D[1].offer(0);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : graph[cur.idx]) {
                if (D[next.idx].size() < k) {
                    D[next.idx].offer(cur.dist + next.dist);
                    pq.offer(new Node(next.idx, cur.dist + next.dist));
                } else {
                    if (D[next.idx].peek() > cur.dist + next.dist) {
                        D[next.idx].poll();
                        D[next.idx].offer(cur.dist + next.dist);
                        pq.offer(new Node(next.idx, cur.dist + next.dist));
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (D[i].size() < k) System.out.println(-1);
            else System.out.println(D[i].peek());
        }
    }

    static class Node {
        int idx, dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int stoi(String s) { return Integer.parseInt(s); }
}

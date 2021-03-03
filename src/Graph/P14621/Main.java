package Graph.P14621;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, u, v, d;
    static char[] gender;
    static int[] root;
    static PriorityQueue<Node> pq = new PriorityQueue<Node>(((o1, o2) -> o1.d - o2.d));

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P14621/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gender = new char[N+1];
        root = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            gender[i] = st.nextToken().charAt(0);
            root[i] = i;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            if (gender[u] != gender[v]) pq.offer(new Node(u, v, d));
        }

        int dist = 0, cnt = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.fr) == find(cur.to)) continue;
            merge(cur.fr, cur.to);
            dist += cur.d;
            cnt ++;
        }

        if (cnt == N-1) System.out.println(dist);
        else System.out.println(-1);
    }

    static int find(int n) {
        if (root[n] == n) return n;
        return root[n] = find(root[n]);
    }

    static void merge(int a, int b) {
        root[find(a)] = find(b);
    }

    static class Node {
        int fr, to, d;

        public Node(int fr, int to, int d) {
            this.fr = fr;
            this.to = to;
            this.d = d;
        }
    }
}

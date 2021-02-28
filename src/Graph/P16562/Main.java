package Graph.P16562;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, k, cost = 0;
    static int[] A, root;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> A[o1] - A[o2]);

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P16562/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[N];
        root = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            root[i] = i;
            pq.offer(i);
        }
        root[N] = N;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken())-1, w = Integer.parseInt(st.nextToken())-1;
            merge(v, w);
        }

        while (!pq.isEmpty()) {
            int i = pq.poll();
            if (find(i) == find(N)) continue;
            merge(i, N);
            cost += A[i];
        }

        if (k < cost) System.out.println("Oh no");
        else System.out.println(cost);
    }

    static int find(int n) {
        if (root[n] == n) return n;
        return root[n] = find(root[n]);
    }

    static void merge(int a, int b) {
        root[find(b)] = find(a);
    }
}

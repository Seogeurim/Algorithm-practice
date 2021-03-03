package Graph.P16398;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] root;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P16398/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        root = new int[N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (i < j) pq.offer(new int[]{i, j, c});
            }
            root[i] = i;
        }

        long cost = 0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            if (find(c[0]) == find(c[1])) continue;
            merge(c[0], c[1]);
            cost += c[2];
        }

        System.out.println(cost);
    }

    static int find(int n) {
        if (root[n] == n) return n;
        return root[n] = find(root[n]);
    }

    static void merge(int a, int b) {
        root[find(a)] = find(b);
    }
}

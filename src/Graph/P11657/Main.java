package Graph.P11657;

import java.io.*;
import java.util.*;

public class Main {

    final static int INF = Integer.MAX_VALUE;
    static int N, M;
    static Edge[] edges;
    static long[] D;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P11657/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(A, B, C);
        }

        D = new long[N+1];
        Arrays.fill(D, INF); D[1] = 0;

        boolean loop = false;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (D[edge.from] != INF && D[edge.to] > D[edge.from] + edge.time) {
                    if (i == N) { loop = true; break; }
                    D[edge.to] = D[edge.from] + edge.time;
                }
            }
        }

        if (loop) System.out.println(-1);
        else {
            for (int i = 2; i <= N; i++) {
                if (D[i] == INF) System.out.println(-1);
                else System.out.println(D[i]);
            }
        }
    }

    static class Edge {
        int from, to, time;

        public Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
}

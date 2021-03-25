package Graph.swea1251;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static double E;
    static int[] x, y;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/swea1251/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            x = new int[N];
            y = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) x[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) y[i] = Integer.parseInt(st.nextToken());
            E = Double.parseDouble(br.readLine());

            sb.append("#").append(t).append(" ").append(Math.round(prim()*E)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static long prim() {
        boolean[] visited = new boolean[N];
        long[] minEdge = new long[N];
        for (int i = 1; i < N; i++) minEdge[i] = Long.MAX_VALUE;

        long res = 0;
        int cnt = N;
        while (cnt-- > 0) {
            long min_cost = Long.MAX_VALUE;
            int min_node = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i] && min_cost > minEdge[i]) {
                    min_cost = minEdge[i];
                    min_node = i;
                }
            }
            visited[min_node] = true;
            res += min_cost;

            for (int i = 0; i < N; i++) {
                long x_dist = Math.abs(x[min_node] - x[i]);
                long y_dist = Math.abs(y[min_node] - y[i]);
                long cost = x_dist*x_dist + y_dist*y_dist;
                if (!visited[i] && minEdge[i] > cost) {
                    minEdge[i] = cost;
                }
            }
        }

        return res;
    }
}

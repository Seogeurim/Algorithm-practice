package Graph.swea1263;

import java.io.*;
import java.util.*;

public class Solution {

    final static int INF = 1001;
    static int T, N;
    static int[][] D;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/swea1263/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            D = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    D[i][j] = Integer.parseInt(st.nextToken());
                    if (i != j && D[i][j] == 0) D[i][j] = INF;
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
//                        if (i == j || i == k) continue;
                        D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                    }
                }
            }

            int cc_min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int cc = 0;
                for (int j = 0; j < N; j++) cc += D[i][j];
                cc_min = Math.min(cc_min, cc);
            }

            sb.append("#").append(t).append(" ").append(cc_min).append("\n");
        }

        System.out.println(sb.toString());
    }
}

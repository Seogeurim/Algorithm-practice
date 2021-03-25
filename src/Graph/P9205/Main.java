package Graph.P9205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final static int INF = Integer.MAX_VALUE;
    static int t, n;
    static int[] x, y;
    static int[][] D;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P9205/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            x = new int[n+2];
            y = new int[n+2];
            D = new int[n+2][n+2];

            for (int i = 0; i < n+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
                Arrays.fill(D[i], INF);
            }

            for (int i = 0; i < n+2; i++) {
                for (int j = 0; j < n+2; j++) {
                    if (i == j) { D[i][j] = 0; continue; }
                    int cost = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
                    if (cost <= 1000) D[i][j] = 1;
                }
            }

            for (int k = 0; k < n+2; k++) {
                for (int i = 0; i < n+2; i++) {
                    for (int j = 0; j < n+2; j++) {
                        if (i == j) continue;
                        if (D[i][k] == INF || D[k][j] == INF) continue;
                        D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                    }
                }
            }

            if (D[0][n+1] != INF) System.out.println("happy");
            else System.out.println("sad");
        }
    }
}

package Graph.P11404;

import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] D;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P11404/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        D = new int[n+1][n+1];
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (D[a][b] > 0) D[a][b] = Math.min(D[a][b], c);
            else D[a][b] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j || D[i][k] == 0 || D[k][j] == 0) continue;
                    if (D[i][j] == 0) D[i][j] = D[i][k] + D[k][j];
                    else D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
    }
}

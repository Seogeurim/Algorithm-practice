package Graph.P21278;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static int INF = 201;
    static int N, M;
    static int[][] D;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P21278/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        D = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) D[i][j] = INF;
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            D[A][B] = 2;
            D[B][A] = 2;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }

        int I = 0, J = 0, min = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            for (int j = i+1; j <= N; j++) {
                int sum = 0;
                for (int k = 1; k <= N; k++) {
                    sum += Math.min(D[i][k], D[j][k]);
                }
                if (sum < min) {
                    I = i;
                    J = j;
                    min = sum;
                }
            }
        }

        System.out.println(I + " " + J + " " + min);
    }
}

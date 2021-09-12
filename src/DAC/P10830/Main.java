package DAC.P10830;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long B;
    static int[][] mat;
    final static int MOD = 1000;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAC/P10830/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] res = calc(B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) sb.append(res[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[][] calc(long b) {
        if (b == 1L) return mat;
        if (b % 2 == 1) return product(mat, calc(b-1));
        int[][] res = calc(b/2);
        return product(res, res);
    }

    static int[][] product(int[][] A, int[][] B) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }
}

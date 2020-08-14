package Combination.P1256;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] combis = new int[202][202];
    static int MAX = 1000000000;

    static int N, M, K;
    static int aCase, zCase;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/Combination/P1256/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K > comb(N + M, N)) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            while (N + M > 0) {
                if (N == 0 || M == 0) {
                    break;
                }
                aCase = comb(N + M - 1, N - 1);
                zCase = comb(N + M - 1, M - 1);
                if (K <= aCase) {
                    sb.append("a");
                    N--;
                } else {
                    sb.append("z");
                    M--;
                    K -= aCase;
                }
            }

            for (int i = 0; i < N; i++) {
                sb.append('a');
            }
            for (int i = 0; i < M; i++) {
                sb.append('z');
            }
            System.out.println(sb);
        }
    }

    static int comb(int n, int k) {
        if (combis[n][k] != 0)
            return combis[n][k];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == j || j == 0){
                    combis[i][j] = 1;
                } else {
                    long result = combis[i-1][j-1] + combis[i-1][j];
                    if (result > MAX)
                        combis[i][j] = MAX;
                    else
                        combis[i][j] = (int) result;
                }
            }
        }

        return combis[n][k];
    }
}

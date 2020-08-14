package Combination.P11051;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,K;
    static int combis[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        combis = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (j == 0 || i == j)
                    combis[i][j] =  1;
                else combis[i][j] = (combis[i-1][j-1] + combis[i-1][j]) % 10007;
            }
        }

        System.out.println(combis[N][K]);
    }
}

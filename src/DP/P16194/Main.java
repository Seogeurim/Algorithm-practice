package DP.P16194;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] P, D;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P16194/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        P = new int[N+1];
        D = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) P[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            D[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                D[i] = Math.min(D[i], P[j] + D[i-j]);
            }
        }

        System.out.println(D[N]);
    }
}

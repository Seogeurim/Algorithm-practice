package DP.P11052;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] P, D;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P11052/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        P = new int[N+1];
        D = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) P[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                D[i] = Math.max(D[i], P[j] + D[i-j]);
            }
        }

        System.out.println(D[N]);
    }
}

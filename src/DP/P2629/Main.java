package DP.P2629;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] chu;
    static boolean[][] check;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P2629/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        chu = new int[N];
        check = new boolean[N+1][40001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) chu[i] = Integer.parseInt(st.nextToken());

        calc(0, 0);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            if (check[N][Integer.parseInt(st.nextToken())]) System.out.print("Y ");
            else System.out.print("N ");
        }
        System.out.println();
    }

    static void calc(int i, int weight) {
        if (i > N || weight > 40000 || check[i][weight]) return;
        check[i][weight] = true;

        if (i == N) return;
        calc(i+1, weight);
        calc(i+1, weight + chu[i]);
        calc(i+1, Math.abs(weight - chu[i]));
    }
}

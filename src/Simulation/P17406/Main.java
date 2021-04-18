package Simulation.P17406;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, ans = Integer.MAX_VALUE;
    static int[][] A, R, del = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P17406/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        A = new int[N][M];
        R = new int[K][3];
        selected = new boolean[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            R[i][0] = stoi(st.nextToken());
            R[i][1] = stoi(st.nextToken());
            R[i][2] = stoi(st.nextToken());
        }

        dfs(0, A);
        System.out.println(ans);
    }

    static int stoi(String s) { return Integer.parseInt(s); }

    static void dfs(int cnt, int[][] arr) {
        if (cnt == K) {
            ans = Math.min(ans, getValue(arr));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!selected[i]) {
                selected[i] = true;
                int[][] a = new int[N][M];
                for (int j = 0; j < N; j++) a[j] = Arrays.copyOf(arr[j], M);
                dfs(cnt+1, rotate(a, R[i][0]-1, R[i][1]-1, R[i][2]));
                selected[i] = false;
            }
        }
    }

    static int getValue(int[][] a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int val = 0;
            for (int j = 0; j < M; j++) {
                val += a[i][j];
            }
            min = Math.min(min, val);
        }
        return min;
    }

    static int[][] rotate(int[][] a, int r, int c, int s) {
        while (s > 0) {
            int i = r-s, j = c-s, d = 0, cur = a[i][j], next;
            while (true) {
                int ti = i + del[d][0], tj = j + del[d][1];
                if (ti < r-s || ti > r+s || tj < c-s || tj > c+s) {
                    if (++d == 4) break;
                    ti = i + del[d][0];
                    tj = j + del[d][1];
                }
                next = a[ti][tj];
                a[ti][tj] = cur;
                cur = next;
                i = ti; j = tj;
            }
            s--;
        }
        return a;
    }
}

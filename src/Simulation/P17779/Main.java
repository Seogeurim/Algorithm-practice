package Simulation.P17779;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, ans = Integer.MAX_VALUE;
    static int[][] A;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P17779/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int d1 = 1; d1 <= N; d1++) {
            for (int d2 = 1; d2 <= N; d2++) {
                for (int x = 1; x <= N; x++) {
                    for (int y = 1; y <= N; y++) {
                        if (x+d1+d2 <= N && 1 <= y-d1 && y+d2 <= N) {
                            solve(x, y, d1, d2);
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static void solve(int x, int y, int d1, int d2) {
        int[] p = new int[6];
        int[][] check = new int[N+1][N+1];

        for (int i = 1; i < x+d1; i++) {
            int j = 1, k = i < x ? y : y-(i-x)-1;
            for (; j <= k && j <= y; j++) check[i][j] = 1;
            for (; j <= y; j++) check[i][j] = 5;
        }
        for (int i = 1; i <= x+d2; i++) {
            int j = y+1, k = i <= x ? y : y+(i-x);
            for (; j <= k && j <= N; j++) check[i][j] = 5;
            for (; j <= N; j++) check[i][j] = 2;
        }
        for (int i = x+d1, k = y-d1-1; i <= N; i++, k++) {
            int j = 1;
            for (; j <= k && j < y-d1+d2; j++) check[i][j] = 3;
            for (; j < y-d1+d2; j++) {
                if (check[i][j] > 0) continue;
                check[i][j] = 5;
            }
        }
        for (int i = x+d2+1, k = y+d2-1; i <= N; i++, k--) {
            int j = y-d1+d2;
            for (; j <= k && j <= N; j++) {
                if (check[i][j] > 0) continue;
                check[i][j] = 5;
            }
            for (; j <= N; j++) check[i][j] = 4;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (check[i][j] == 0) p[5] += A[i][j];
                else p[check[i][j]] += A[i][j];
            }
        }

        int min = p[1], max = p[1];
        for (int i = 2; i <= 5; i++) {
            min = Math.min(min, p[i]);
            max = Math.max(max, p[i]);
        }
        ans = Math.min(ans, max - min);
    }
}

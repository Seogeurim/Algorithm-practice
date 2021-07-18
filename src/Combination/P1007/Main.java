package Combination.P1007;

import java.io.*;
import java.util.*;

public class Main {

    static int T, N;
    static int[] x, y;
    static double min;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Combination/P1007/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            x = new int[N];
            y = new int[N];
            double x_sub = 0, y_sub = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
                x_sub -= x[i];
                y_sub -= y[i];
            }
            min = Double.MAX_VALUE;
            comb(0, 0, 0, 0, x_sub, y_sub);
            System.out.printf("%.6f\n", min);
        }
    }

    static void comb(int start, int cnt, double x_sum, double y_sum, double x_sub, double y_sub) {
        if (cnt == N/2) {
            double x_res = x_sum + x_sub;
            double y_res = y_sum + y_sub;
            min = Math.min(min, Math.sqrt(x_res*x_res + y_res*y_res));
            return;
        }

        for (int i = start; i < N; i++) {
            comb(i+1, cnt+1, x_sum+x[i], y_sum+y[i], x_sub+x[i], y_sub+y[i]);
        }
    }
}

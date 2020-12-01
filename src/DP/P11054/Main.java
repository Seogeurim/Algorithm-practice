package DP.P11054;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int[] inc, dec;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P11054/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        inc = new int[N];
        dec = new int[N];
        for (int i = 0; i < N; i++) {
            int max_inc = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    max_inc = Math.max(max_inc, inc[j]);
                }
            }
            inc[i] = max_inc + 1;
        }
        for (int i = N-1; i >= 0; i--) {
            int max_dec = 0;
            for (int j = N-1; j > i; j--) {
                if (A[j] < A[i]) {
                    max_dec = Math.max(max_dec, dec[j]);
                }
            }
            dec[i] = max_dec + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, inc[i] + dec[i] - 1);
        }

        System.out.println(ans);
    }
}

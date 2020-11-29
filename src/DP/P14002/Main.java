package DP.P14002;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int[][] dp;
    final static int FLAG = 10000;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P14002/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        dp = new int[N][2];
        int maxLength = 0, maxLengthIdx = 0;
        for (int i = 0; i < N; i++) {
            int maxIdx = 0, last = -1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    if (maxIdx < dp[j][0]) {
                        maxIdx = dp[j][0];
                        last = j;
                    }
                }
            }
            dp[i][0] = maxIdx + 1;
            dp[i][1] = last;

            if (maxLength < dp[i][0]) {
                maxLength = dp[i][0];
                maxLengthIdx = i;
            }
        }

        int now = maxLengthIdx;
        while (true) {
            A[now] += FLAG;
            if (dp[now][1] == -1) break;
            now = dp[now][1];
        }

        System.out.println(maxLength);
        for (int i = 0; i < N; i++) {
            if (A[i] > FLAG) System.out.print((A[i] - FLAG) + " ");
        }
        System.out.println();
    }
}

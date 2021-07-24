package DP.P15678;

import java.io.*;
import java.util.*;

public class Main {

    static int N, D, K;
    static long ans = Long.MIN_VALUE;
    static long[] dp;
    static Deque<Integer> dq;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P15678/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dp = new long[N];
        dq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            K = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && i - dq.peekFirst() > D) dq.removeFirst();
            dp[i] = Math.max(dq.isEmpty() ? K : dp[dq.peekFirst()] + K, K);
            ans = Math.max(ans, dp[i]);
            while (!dq.isEmpty() && dp[dq.peekLast()] < dp[i]) dq.removeLast();
            dq.add(i);
        }

        System.out.println(ans);
    }
}

package BruteForce.swea3234;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, ans;
    static int[] W;
    static boolean[] select;

    static int[] fact = new int[10];
    static int[] pow = new int[10];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BruteForce/swea3234/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        fact[0] = 1; pow[0] = 1;
        for (int i = 1; i <= 9; i++) {
            fact[i] = i * fact[i-1];
            pow[i] = 2 * pow[i-1];
        }

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            W = new int[N];

            int total = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                W[i] = Integer.parseInt(st.nextToken());
                total += W[i];
            }

            ans = 0;
            select = new boolean[N];
            solve(0, 0, 0, total);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void solve(int cnt, int left, int right, int remain) {
        if (left < right) return;
        if (left >= right + remain) {
            ans += pow[N-cnt] * fact[N-cnt];
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!select[i]) {
                select[i] = true;
                solve(cnt+1, left+W[i], right, remain-W[i]);
                solve(cnt+1, left, right+W[i], remain-W[i]);
                select[i] = false;
            }
        }
    }
}

package BruteForce.swea4012;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, ans;
    static int[][] map;
    static boolean[] select;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BruteForce/swea4012/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            ans = Integer.MAX_VALUE;
            select = new boolean[N];
            comb(1, 0);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void comb(int idx, int cnt) {
        if (cnt == N/2) {
            int[] m1 = new int[N/2], m2 = new int[N/2];
            for (int i = 0, j = 0, k = 0; i < N; i++) {
                if (select[i]) m1[j++] = i;
                else m2[k++] = i;
            }
            ans = Math.min(ans, Math.abs(calS(m1) - calS(m2)));
            return;
        }

        for (int i = idx; i < N; i++) {
            select[i] = true;
            comb(i+1, cnt+1);
            select[i] = false;
        }
    }

    static int calS(int[] m) {
        int s = 0;
        for (int i = 0; i < N/2-1; i++) {
            for (int j = i; j < N/2; j++) {
                s += map[m[i]][m[j]] + map[m[j]][m[i]];
            }
        }
        return s;
    }
}

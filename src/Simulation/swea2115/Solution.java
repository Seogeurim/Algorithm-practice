package Simulation.swea2115;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M, C;
    static int[][] map;
    static int[] select;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/swea2115/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int rcnt = N-M+1;
            select = new int[N*rcnt];
            for (int i = 0, cnt = 0; i < N; i++) {
                for (int j = 0; j < rcnt; j++) {
                    select[cnt++] = collect(i, j);
                }
            }

            int ans = 0;
            for (int i = 0, size = N*rcnt, r = rcnt; i < size; i++) {
                int j = i+M;
                for (; j < r; j++) ans = Math.max(ans, select[i] + select[j]);
                for (j = r; j < size; j++) ans = Math.max(ans, select[i] + select[j]);
                if (i == r-1) r += rcnt;
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int collect(int i, int j) {
        int res = 0;
        int[] sub = Arrays.copyOfRange(map[i], j, j+M);
        Arrays.sort(sub);
        for (int flag = 1; flag < 1<<M; flag++) {
            int amt = 0;
            for (int k = M-1, c = 0; k >= 0; k--) {
                if ((flag & 1<<k) != 0) {
                    c += sub[k];
                    if (c > C) break;
                    amt += sub[k]*sub[k];
                }
            }
            res = Math.max(res, amt);
        }
        return res;
    }
}

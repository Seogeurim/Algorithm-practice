package Array.swea2001;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M, max;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Array/swea2001/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i < M-1 || j < M-1) continue;
                    int sum = 0;
                    for (int m_i = i; m_i > i-M; m_i--) {
                        for (int m_j = j; m_j > j-M; m_j--) {
                            sum += map[m_i][m_j];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }
}

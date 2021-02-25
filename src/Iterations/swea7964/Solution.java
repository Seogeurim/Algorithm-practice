package Iterations.swea7964;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, D, C;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Iterations/swea7964/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            int cnt = 0, dist = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                C = Integer.parseInt(st.nextToken());
                if (C == 1) {
                    dist = 0;
                } else {
                    dist ++;
                    if (dist == D) { cnt ++; dist = 0; }
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}

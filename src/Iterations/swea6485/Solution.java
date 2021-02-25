package Iterations.swea6485;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, A, B, P, C;
    static int[] bus;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Iterations/swea6485/s_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            bus = new int[5001];
            N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                for (int j = A; j <= B; j++) bus[j] ++;
            }
            sb.append("#").append(t).append(" ");
            P = Integer.parseInt(br.readLine());
            while (P-- > 0) {
                C = Integer.parseInt(br.readLine());
                sb.append(bus[C]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
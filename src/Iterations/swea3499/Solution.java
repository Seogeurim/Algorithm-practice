package Iterations.swea3499;

import java.io.*;

public class Solution {

    static int T, N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Iterations/swea3499/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            N = Integer.parseInt(br.readLine());
            String[] card = br.readLine().split(" ");
            int N_ = N;
            if (N%2 == 1) N_++;
            for (int i = 0; i < N_/2; i++) {
                sb.append(card[i]).append(" ");
                if (N_/2+i < N) sb.append(card[N_/2+i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

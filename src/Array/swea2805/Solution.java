package Array.swea2805;

import java.io.*;

public class Solution {

    static int T, N;
    static int sum;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Array/swea2805/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            sum = 0;
            for (int i = 0; i < N; i++) {
                String row = br.readLine();
                int k = i == N/2 ? 0 : Math.abs(N/2 - i);
                for (int j = k; j < N-k; j++) sum += row.charAt(j) - '0';
            }
            System.out.println("#" + t + " " + sum);
        }
    }
}

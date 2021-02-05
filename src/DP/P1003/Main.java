package DP.P1003;

import java.io.*;

public class Main {

    static int T, N;
    static int[] zero = new int[41], one = new int[41];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P1003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        zero[0] = 1; one[1] = 1;
        for (int i = 2; i <= 40; i++) {
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            System.out.println(zero[N] + " " + one[N]);
        }
    }
}

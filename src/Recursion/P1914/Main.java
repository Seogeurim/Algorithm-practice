package Recursion.P1914;

import java.io.*;
import java.math.BigInteger;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Recursion/P1914/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.println(new BigInteger("2").pow(N).subtract(new BigInteger("1")));
        if (N <= 20) {
            hanoi(N, 1, 2, 3);
            System.out.print(sb.toString());
        }
    }

    static void hanoi(int cnt, int from, int tmp, int to) {
        if (cnt == 0) return;

        hanoi(cnt-1, from, to, tmp);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(cnt-1, tmp, from, to);
    }
}

package Combination.P11050;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(combination(N, K));
    }

    static int combination(int n, int k) {
        if (k == 0 || n == k)
            return 1;
        return combination(n-1, k-1) + combination(n-1, k);
    }
}

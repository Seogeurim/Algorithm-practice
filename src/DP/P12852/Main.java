package DP.P12852;

import java.io.*;

public class Main {

    static int N;
    static int[] cnt = new int[1000001], memo = new int[1000001];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P12852/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 2; i <= N; i++) {
            cnt[i] = cnt[i-1] + 1;
            memo[i] = i-1;
            if (i % 3 == 0 && cnt[i] > cnt[i/3] + 1) {
                cnt[i] = cnt[i/3] + 1;
                memo[i] = i/3;
            }
            if (i % 2 == 0 && cnt[i] > cnt[i/2] + 1) {
                cnt[i] = cnt[i/2] + 1;
                memo[i] = i/2;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt[N]).append("\n");
        while (N >= 1) {
            sb.append(N).append(" ");
            N = memo[N];
        }
        System.out.println(sb.toString());
    }
}

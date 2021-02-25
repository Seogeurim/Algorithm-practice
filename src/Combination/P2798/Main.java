package Combination.P2798;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans;
    static int[] cards;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Combination/P2798/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cards[i] = Integer.parseInt(st.nextToken());

        comb(0, 0, 0);
        System.out.println(ans);
    }

    static void comb(int start, int cnt, int sum) {
        if (sum > M) return;
        if (cnt == 3) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = start; i < N; i++) {
            comb(i+1, cnt+1, sum+cards[i]);
        }
    }
}

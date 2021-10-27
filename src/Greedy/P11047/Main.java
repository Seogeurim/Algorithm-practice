package Greedy.P11047;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K, cnt = 0;
    static int[] coins;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Greedy/P11047/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N];
        for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());

        for (int i = N-1; i >= 0; i--) {
            if (K < coins[i]) continue;
            cnt += K/coins[i];
            K %= coins[i];
        }

        System.out.println(cnt);
    }
}

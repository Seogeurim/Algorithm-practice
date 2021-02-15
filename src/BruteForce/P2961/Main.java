package BruteForce.P2961;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, ans = 1000000000;
    static int[][] sb;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BruteForce/P2961/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sb = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb[i][0] = Integer.parseInt(st.nextToken());
            sb[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 1<<N; i++) {
            int S = 1, B = 0;
            for (int j = 0; j < N; j++) {
                if ((i & 1<<j) > 0) {
                    S *= sb[j][0];
                    B += sb[j][1];
                }
            }
            ans = Math.min(ans, Math.abs(S-B));
        }

        System.out.println(ans);
    }
}

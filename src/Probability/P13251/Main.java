package Probability.P13251;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N = 0, M, K;
    static int[] colors;
    static double ans = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Probability/P13251/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());

        colors = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
            N += colors[i];
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            double colorPro = 1;
            for (int j = 0; j < K; j++) {
                colorPro *= (double) (colors[i] - j) / (N - j);
            }
            ans += colorPro;
        }

        System.out.println(ans);
    }
}

package Simulation.P13300;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, S, Y, ans;
    static int[][] students = new int[7][2];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P13300/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            students[Y][S] ++;
        }

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) ans += Math.ceil((double) students[i][j] / K);
        }

        System.out.println(ans);
    }
}

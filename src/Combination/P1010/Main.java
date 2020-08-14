package Combination.P1010;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;
    static int combis[][];

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/Combination/P1010/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            combis = new int[M+1][N+1];
            for (int i = 1; i <= M; i++) {
                for (int j = 0; j <= N; j++) {
                    if (j == 0 || i == j)
                        combis[i][j] =  1;
                    else combis[i][j] = (combis[i-1][j-1] + combis[i-1][j]);
                }
            }

            System.out.println(combis[M][N]);
        }
    }
}

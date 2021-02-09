package Simulation.P2563;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map = new int[100][100];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P2563/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            for (int i = y; i < y+10; i++) {
                for (int j = x; j < x+10; j++) {
                    map[i][j] = 1;
                }
            }
        }

        int black = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                black += map[i][j];
            }
        }

        System.out.println(black);
    }
}

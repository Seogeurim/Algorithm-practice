package Simulation.jo1037;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/jo1037/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (isParity()) System.out.println("OK");
        else chageBit();

    }

    static void chageBit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = 1 - map[i][j];
                if (isParity()) {
                    System.out.println("Change bit (" + (i+1) + "," + (j+1) + ")");
                    return;
                }
                map[i][j] = 1 - map[i][j];
            }
        }

        System.out.println("Corrupt");
    }

    static boolean isParity() {
        int rCnt = 0, cCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rCnt += map[i][j];
                cCnt += map[j][i];
            }
            if (rCnt%2 != 0 || cCnt%2 != 0) return false;
        }

        return true;
    }
}

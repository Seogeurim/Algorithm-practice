package Simulation.P14499;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M, i, j, K;
    static int[][] map;
    static int[] dice = new int[7];

    static int[] di = {0, 0, -1, 1};
    static int[] dj = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P14499/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        i = stoi(st.nextToken());
        j = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (K-- > 0) {
            int cmd = stoi(st.nextToken());

            int to_i = i + di[cmd-1], to_j = j + dj[cmd-1];
            if (!isValidPath(to_i, to_j)) continue;
            i = to_i; j = to_j;

            switch (cmd) {
                case 1:
                    int tmp = dice[4];
                    dice[4] = dice[6];
                    dice[6] = dice[3];
                    dice[3] = dice[1];
                    dice[1] = tmp;
                    break;
                case 2:
                    tmp = dice[3];
                    dice[3] = dice[6];
                    dice[6] = dice[4];
                    dice[4] = dice[1];
                    dice[1] = tmp;
                    break;
                case 3:
                    tmp = dice[5];
                    dice[5] = dice[6];
                    dice[6] = dice[2];
                    dice[2] = dice[1];
                    dice[1] = tmp;
                    break;
                case 4:
                    tmp = dice[2];
                    dice[2] = dice[6];
                    dice[6] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = tmp;
                    break;
            }

            if (map[i][j] == 0) map[i][j] = dice[6];
            else { dice[6] = map[i][j]; map[i][j] = 0; }

            System.out.println(dice[1]);
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }

    static int stoi(String s) { return Integer.parseInt(s); }
}

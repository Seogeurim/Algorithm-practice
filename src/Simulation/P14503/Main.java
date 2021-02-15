package Simulation.P14503;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M, i, j, d, sum;
    static int[][] map;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P14503/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        i = stoi(st.nextToken());
        j = stoi(st.nextToken());
        d = stoi(st.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) map[r][c] = stoi(st.nextToken());
        }

        int dcnt = 0;
        map[i][j] = 2; sum ++;
        while (true) {
            int to_d = d-1 < 0 ? 3 : d-1;
            int to_i = i + di[to_d], to_j = j + dj[to_d];

            if (isValidPath(to_i, to_j)) {
                if (map[to_i][to_j] == 0) {
                    d = to_d; i = to_i; j = to_j; dcnt = 0;
                    map[i][j] = 2; sum ++;
                } else {
                    d = to_d; dcnt ++;
                }
            }

            if (dcnt == 4) {
                to_i = i - di[to_d];
                to_j = j - dj[to_d];

                if (!isValidPath(to_i, to_j) || map[to_i][to_j] == 1) break;

                i = to_i;
                j = to_j;
                dcnt = 0;
            }
        }

        System.out.println(sum);
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }

    static int stoi(String s) { return Integer.parseInt(s); }
}

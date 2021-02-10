package Simulation.P16935;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P16935/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (R-- > 0) {
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1: op1(); break;
                case 2: op2(); break;
                case 3: op3(); break;
                case 4: op4(); break;
                case 5: op5(); break;
                case 6: op6(); break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static void op1() {
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            result[i] = map[N-i-1];
        }
        map = result;
    }

    static void op2() {
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = map[i][M-j-1];
            }
        }
        map = result;
    }

    static void op3() {
        int[][] result = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = map[N-j-1][i];
            }
        }
        map = result;
        int tmp = N; N = M; M = tmp;
    }

    static void op4() {
        int[][] result = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = map[j][M-i-1];
            }
        }
        map = result;
        int tmp = N; N = M; M = tmp;
    }

    static void op5() {
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (i < N/2) {
                System.arraycopy(map[N/2+i], 0, result[i], 0, M/2);
                System.arraycopy(map[i], 0, result[i], M/2, M/2);
            } else {
                System.arraycopy(map[i], M/2, result[i], 0, M/2);
                System.arraycopy(map[i-N/2], M/2, result[i], M/2, M/2);
            }
        }
        map = result;
    }

    static void op6() {
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (i < N/2) {
                System.arraycopy(map[i], M/2, result[i], 0, M/2);
                System.arraycopy(map[N/2+i], M/2, result[i], M/2, M/2);
            } else {
                System.arraycopy(map[i-N/2], 0, result[i], 0, M/2);
                System.arraycopy(map[i], 0, result[i], M/2, M/2);
            }
        }
        map = result;
    }
}

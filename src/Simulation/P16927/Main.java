package Simulation.P16927;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] origin, result;

    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P16927/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        origin = new int[N][M];
        result = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int s = 0; s < Math.min(N, M)/2; s++) {
            int n = N - s*2, m = M - s*2;
            int cnt = (n + m) * 2 - 4;
            int i = s, j = s, dir = 0, r = R % cnt;
            int[] pos = new int[cnt];
            for (int c = 0; c < cnt + r; c++) {
                if (c < cnt) pos[c] = origin[i][j];
                if (c >= r) result[i][j] = pos[c-r];
                if (!canGo(i + di[dir % 4], j + dj[dir % 4], s, n, m)) dir++;
                i += di[dir % 4];
                j += dj[dir % 4];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static boolean canGo(int i, int j, int s, int n, int m) {
        return s <= i && i < s+n && s <= j && j < s+m;
    }
}

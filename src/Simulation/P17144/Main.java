package Simulation.P17144;

import java.io.*;
import java.util.*;

public class Main {

    static int R, C, T, pi, pj, ans;
    static int[][] A, tmp;
    static int[] di = {-1, 0, 1, 0}, dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P17144/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        A = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == -1) { pi = i; pj = j; }
            }
        }

        while (T-- > 0) {
            tmp = new int[R][C];
            spread();
            for (int i = 0; i < R; i++) {
                A[i] = Arrays.copyOf(tmp[i], C);
            }
            rotate(pi-1, pj, new int[]{1, 0, 3, 2});
            rotate(pi, pj, new int[]{1, 2, 3, 0});
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) ans += A[i][j];
            }
        }
        System.out.println(ans);
    }

    static void spread() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + di[k], nj = j + dj[k];
                        if (!isValidPath(ni, nj) || A[ni][nj] == -1) continue;
                        tmp[ni][nj] += A[i][j]/5;
                        cnt ++;
                    }
                    tmp[i][j] += A[i][j] - (A[i][j]/5) * cnt;
                }
            }
        }
    }

    static void rotate(int i, int j, int[] d) {
        A[i][j] = -1;
        for (int k = 0; k < 4;) {
            if (!isValidPath(i+di[d[k]], j+dj[d[k]])) k++;
            int ni = i+di[d[k]], nj = j+dj[d[k]];
            if (A[ni][nj] == -1) return;
            A[ni][nj] = tmp[i][j];
            i = ni; j = nj;
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < R && 0 <= j && j < C;
    }
}

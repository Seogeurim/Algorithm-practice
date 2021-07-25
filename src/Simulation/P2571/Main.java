package Simulation.P2571;

import java.io.*;
import java.util.*;

public class Main {

    static int ans = 100;
    static int[][] map = new int[101][101];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P2571/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            for (int k = i; k < i+10; k++) {
                for (int l = j; l < j+10; l++) {
                    map[k][l] = 1;
                }
            }
        }

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (map[i][j] == 1) solve(i, j);
            }
        }

        System.out.println(ans);
    }

    static void solve(int s_i, int s_j) {
        int i_len = 1, j_len;
        while (s_i+i_len <= 100 && map[s_i+i_len][s_j] == 1) {
            i_len ++;
            j_len = 1;

            while (s_j+j_len <= 100 && map[s_i][s_j+j_len] == 1) {
                j_len ++;
                if (check(s_i, s_j, i_len, j_len)) {
                    ans = Math.max(ans, i_len*j_len);
                }
            }
        }
    }

    static boolean check(int s_i, int s_j, int i_len, int j_len) {
        for (int i = s_i; i < s_i+i_len; i++) {
            for (int j = s_j; j < s_j+j_len; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }
}

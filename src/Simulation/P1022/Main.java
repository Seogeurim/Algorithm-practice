package Simulation.P1022;

import java.io.*;
import java.util.*;

public class Main {

    static int r1, c1, r2, c2;
    static int[][] map;
    static int max;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P1022/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        map = new int[r2-r1+1][c2-c1+1];
        int n = Math.max(Math.max(Math.abs(r1), Math.abs(r2)), Math.max(Math.abs(c1), Math.abs(c2)));
        make(-r1, -c1, n*2+1);

        StringBuilder sb = new StringBuilder();
        int maxLen = String.valueOf(max).length();
        for (int i = 0; i <= r2-r1; i++) {
            for (int j = 0; j <= c2-c1; j++) {
                String m = String.valueOf(map[i][j]);
                for (int k = 0; k < maxLen-m.length(); k++) sb.append(" ");
                sb.append(m).append(" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void make(int i, int j, int n) {
        int[] di = {0, -1, 0, 1};
        int[] dj = {1, 0, -1, 0};
        if (isValidPath(i, j)) map[i][j] = 1;
        int d = 0, k = 1, num = 2;
        while (num <= n*n) {
            for (int c = 0; c < 2; c++) {
                for (int l = 0; l < k; l++) {
                    i+= di[d];
                    j+= dj[d];
                    if (isValidPath(i, j)) {
                        map[i][j] = num;
                        max = Math.max(max, num);
                    }
                    num ++;
                }
                d++;
            }
            k++;
            d %= 4;
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i <= r2-r1 && 0 <= j && j <= c2-c1;
    }
}

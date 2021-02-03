package Simulation.swea1873;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, H, W, N;
    static char[][] map;
    static int[] cur;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static String dirs = "^v<>UDLR";

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/swea1873/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (dirs.indexOf(map[i][j]) >= 0) cur = new int[]{i, j, dirs.indexOf(map[i][j])};
                }
            }

            N = Integer.parseInt(br.readLine());
            String cmds = br.readLine();

            for (int i = 0; i < N; i++) {
                char cmd = cmds.charAt(i);
                if (cmd == 'S') {
                    int to_i = cur[0], to_j = cur[1];
                    while (true) {
                        to_i += di[cur[2]];
                        to_j += dj[cur[2]];
                        if (!isValidPath(to_i, to_j)) break;
                        if (map[to_i][to_j] == '*') { map[to_i][to_j] = '.'; break; }
                        if (map[to_i][to_j] == '#') break;
                    }
                } else {
                    cur[2] = dirs.indexOf(cmd) % 4;
                    map[cur[0]][cur[1]] = '.';
                    int to_i = cur[0] + di[cur[2]], to_j = cur[1] + dj[cur[2]];
                    if (isValidPath(to_i, to_j) && map[to_i][to_j] == '.') {
                        cur[0] = to_i;
                        cur[1] = to_j;
                    }
                    map[cur[0]][cur[1]] = dirs.charAt(cur[2]);
                }
            }

            bw.write("#" + t + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) bw.write(map[i][j]);
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isValidPath(int i, int j) { return 0 <= i && i < H && 0 <= j && j < W; }
}

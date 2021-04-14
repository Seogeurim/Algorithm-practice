package Simulation.swea5656;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, W, H, ans;
    static int[][] map, tmp;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/swea5656/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            tmp = new int[H][W];
            ans = W*H;
            dfs(0, ans);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int cnt, int res) {
        if (cnt == N || res == 0) {
            ans = Math.min(ans, res);
            return;
        }

        for (int w = 0; w < W; w++) {
            for (int h = 0; h < H; h++) {
                if (map[h][w] > 0) {
                    int[][] copy = new int[H][W];
                    for (int i = 0; i < H; i++) {
                        copy[i] = Arrays.copyOf(map[i], W);
                        tmp[i] = Arrays.copyOf(map[i], W);
                    }
                    crash(h, w);
                    dfs(cnt+1, down());
                    for (int i = 0; i < H; i++) map[i] = Arrays.copyOf(copy[i], W);
                    break;
                }
            }
        }
    }

    static void crash(int i, int j) {
        tmp[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            for (int n = 1; n < map[i][j]; n++) {
                int to_i = i + di[k]*n;
                int to_j = j + dj[k]*n;
                if (!isValidPath(to_i, to_j)) break;
                if (tmp[to_i][to_j] > 0) crash(to_i, to_j);
            }
        }
    }

    static int down() {
        int cnt = 0;
        map = new int[H][W];
        for (int j = 0; j < W; j++) {
            for (int i = H-1, k = H-1; i >= 0; i--) {
                if (tmp[i][j] > 0) {
                    map[k--][j] = tmp[i][j];
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < H && 0 <= j && j < W;
    }
}

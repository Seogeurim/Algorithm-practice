package Simulation.P2636;

import java.io.*;
import java.util.*;

public class Main {

    static int R, C, total;
    static int[][] map;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P2636/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) total ++;
            }
        }

        solve();
    }

    static void solve() {
        Queue<Pos> air = new LinkedList<>();
        Queue<Pos> cheese = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        int time = 0;

        air.add(new Pos(0, 0));
        while (total > 0) {
            time ++;

            while (!air.isEmpty()) {
                Pos p = air.poll();
                visited[p.i][p.j] = true;

                for (int k = 0; k < 4; k++) {
                    int to_i = p.i + di[k];
                    int to_j = p.j + dj[k];

                    if (!isValidPath(to_i, to_j) || visited[to_i][to_j]) continue;

                    visited[to_i][to_j] = true;
                    if (map[to_i][to_j] == 0) {
                        air.offer(new Pos(to_i, to_j));
                    } else {
                        cheese.offer(new Pos(to_i, to_j));
                        total --;
                    }
                }
            }

            air.addAll(cheese);
            cheese.clear();
        }

        System.out.println(time);
        System.out.println(air.size());
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < R && 0 <= j && j < C;
    }

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

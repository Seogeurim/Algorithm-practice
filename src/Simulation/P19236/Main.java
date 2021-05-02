package Simulation.P19236;

import java.io.*;
import java.util.*;

public class Main {

    final static int[] di = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    final static int[] dj = {0, 0, -1, -1, -1, 0, 1, 1, 1};

    static int ans;
    static int[][] map;
    static Pos[] fishes;
    static boolean[] shark;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P19236/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[4][4];
        fishes = new Pos[17];
        shark = new boolean[17];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int v = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                map[i][j] = v;
                fishes[v] = new Pos(i, j, d);
            }
        }

        int start = map[0][0];
        shark[start] = true;
        moveFish(0, 0);
        moveShark(0, 0, fishes[start].d, start);

        System.out.println(ans);
    }

    static void moveShark(int i, int j, int d, int sum) {

        int tmp = map[i][j];
        map[i][j] = 0;
        for (int k = 1; k < 4; k++) {
            int to_i = i + di[d]*k;
            int to_j = j + dj[d]*k;

            if (!isValidPath(to_i, to_j) || map[to_i][to_j] == 0) continue;

            Pos[] copyFish = new Pos[17];
            System.arraycopy(fishes, 1, copyFish, 1, 16);

            shark[map[to_i][to_j]] = true;
            moveFish(to_i, to_j);
            moveShark(to_i, to_j, fishes[map[to_i][to_j]].d, sum+map[to_i][to_j]);

            shark[map[to_i][to_j]] = false;
            System.arraycopy(copyFish, 1, fishes, 1, 16);
            map = new int[4][4];
            for (int f = 1; f <= 16; f++) {
                if (shark[f]) continue;
                Pos p = fishes[f];
                map[p.i][p.j] = f;
            }
        }
        map[i][j] = tmp;

        ans = Math.max(ans, sum);
    }

    static void moveFish(int sh_i, int sh_j) {
        for (int i = 1; i <= 16; i++) {
            if (shark[i]) continue;
            Pos fish = fishes[i];
            for (int k = fish.d; k < fish.d+8; k++) {
                int to_d = k > 8 ? k-8 : k;
                int to_i = fish.i + di[to_d];
                int to_j = fish.j + dj[to_d];
                if (!isValidPath(to_i, to_j) || (to_i == sh_i && to_j == sh_j)) continue;

                if (map[to_i][to_j] == 0) {
                    fishes[i] = new Pos(to_i, to_j, to_d);
                } else {
                    Pos tmp = fishes[map[to_i][to_j]];
                    fishes[i] = new Pos(tmp.i, tmp.j, to_d);
                    fishes[map[to_i][to_j]] = new Pos(fish.i, fish.j, tmp.d);
                }
                int tmpVal = map[fish.i][fish.j];
                map[fish.i][fish.j] = map[to_i][to_j];
                map[to_i][to_j] = tmpVal;
                break;
            }
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < 4 && 0 <= j && j < 4;
    }

    static class Pos {
        int i, j, d;

        public Pos(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
}

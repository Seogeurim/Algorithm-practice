package Implementation.P2615;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] map = new int[21][21];
    static int[] di = {0, 1, 1, 1};
    static int[] dj = {1, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Implementation/P2615/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        game();
    }

    static void game() {
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (map[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    if (isWin(i, j, k, map[i][j])) {
                        System.out.println(map[i][j]);
                        if (k == 3) System.out.println((i+4) + " " + (j-4));
                        else System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean isWin(int i, int j, int d, int n) {
        int cnt = 1;
        int to_i = i + di[d], to_j = j + dj[d];
        while (isValidPath(to_i, to_j) && map[to_i][to_j] == n) {
            cnt ++;
            to_i += di[d];
            to_j += dj[d];
        }
        int pr_i = i-di[d], pr_j = j-dj[d];
        return cnt == 5 && (!isValidPath(pr_i, pr_j) || map[pr_i][pr_j] != n);
    }

    static boolean isValidPath(int i, int j) {
        return 1 <= i && i <= 19 && 1 <= j && j <= 19;
    }
}

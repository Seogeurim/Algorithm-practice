package BruteForce.P17136;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] map = new int[10][10];
    static int[] cnt = new int[]{0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BruteForce/P17136/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void dfs(int idx, int total) {
        if (total > ans) return;
        if (idx == 100) { ans = total; return; }

        int i = idx/10, j = idx%10;
        if (map[i][j] == 0) dfs(idx+1, total);
        else {
            for (int n = 5; n > 0; n--) {
                if (i+n > 10 || j+n > 10) continue;
                if (cnt[n] > 0 && check(i, j, n)) {
                    cover(i, j, n, 0);
                    cnt[n] --;
                    dfs(idx+1, total+1);
                    cover(i, j, n, 1);
                    cnt[n] ++;
                }
            }
        }
    }

    static boolean check(int s_i, int s_j, int size) {
        for (int i = s_i; i < s_i+size; i++) {
            for (int j = s_j; j < s_j+size; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void cover(int s_i, int s_j, int size, int visit) {
        for (int i = s_i; i < s_i+size; i++) {
            for (int j = s_j; j < s_j+size; j++) {
                map[i][j] = visit;
            }
        }
    }
}

package DFS.P3109;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int R, C, cnt;
    static char[][] map;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P3109/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            map[i][0] = 'p';
            flag = false;
            dfs(i, 0);
        }

        System.out.println(cnt);
    }

    static void dfs(int i, int j) {
        if (j == C-1) {
            cnt ++;
            flag = true;
            return;
        }

        for (int d = -1; d <= 1; d++) {
            int to_i = i + d;
            int to_j = j + 1;

            if (canGo(to_i, to_j) && !flag) {
                map[to_i][to_j] = 'p';
                dfs(to_i, to_j);
            }
        }
    }

    static boolean canGo(int i, int j) {
        return 0 <= i && i < R && 0 <= j && j < C && map[i][j] == '.';
    }
}

package DFS.P4963;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    static int[] di = {-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dj = {0, 1, 0, -1, 1, 1, -1, -1};

    static int count;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P4963/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) return;

            map = new int[h][w];
            visited = new boolean[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j]) {
                        dfs(i, j);
                        if (flag) {
                            count ++;
                            flag = false;
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int cur_i, int cur_j) {
        visited[cur_i][cur_j] = true;

        if (map[cur_i][cur_j] == 1) {
            flag = true;

            for (int t = 0; t < 8; t++) {
                int to_i = cur_i + di[t];
                int to_j = cur_j + dj[t];

                if (isValidPath(to_i, to_j) && !visited[to_i][to_j]) {
                    dfs(to_i, to_j);
                }
            }
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < h && 0 <= j && j < w;
    }
}

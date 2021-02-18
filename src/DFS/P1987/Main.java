package DFS.P1987;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int R, C, max;
    static char[][] map;
    static boolean[] visited = new boolean[26];

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P1987/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();

        visited[map[0][0]-'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int i, int j, int cnt) {
        for (int t = 0; t < 4; t++) {
            int to_i = i + di[t];
            int to_j = j + dj[t];

            if (isValidPath(to_i, to_j) && !visited[map[to_i][to_j]-'A']) {
                visited[map[to_i][to_j]-'A'] = true;
                dfs(to_i, to_j, cnt+1);
                visited[map[to_i][to_j]-'A'] = false;
            }
        }
        max = Math.max(max, cnt);
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < R && 0 <= j && j < C;
    }
}

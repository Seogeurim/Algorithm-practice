package DFS.P17070;

import java.io.*;
import java.util.*;

public class Main {

    static int N, cnt;
    static int[][] map;
    static int[][] del = {{0, 1}, {1, 0}, {1, 1}};
    final static int R = 0, D = 1, RD = 2;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P17070/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        if (map[N-1][N-1] != 1) dfs(0, 1, R);
        System.out.println(cnt);
    }

    static void dfs(int i, int j, int d) {
        for (int to_d = 0; to_d < 3; to_d++) {
            if ((to_d == R && d == D) || (to_d == D && d == R)) continue;
            int to_i = i + del[to_d][0];
            int to_j = j + del[to_d][1];
            if (!isValidPath(to_i, to_j) || map[to_i][to_j] == 1) continue;
            if (to_d == RD && (map[i][j+1] == 1 || map[i+1][j] == 1)) continue;
            if (to_i == N-1 && to_j == N-1) { cnt++; continue; }
            dfs(to_i, to_j, to_d);
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}

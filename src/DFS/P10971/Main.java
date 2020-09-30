package DFS.P10971;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] W;

    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P10971/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            solve(i, i, 0, 0);
        }

        System.out.println(min);
    }

    static void solve(int start, int from, int count, int sum) {
        if (count == N && start == from) {
            min = Math.min(min, sum);
            return;
        }

        for (int to = 0; to < N; to++) {
            if (!visited[to] && W[from][to] != 0) {
                visited[to] = true;
                solve(start, to, count + 1, sum + W[from][to]);
                visited[to] = false;
            }
        }
    }
}

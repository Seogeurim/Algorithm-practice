package DFS.P2667;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static boolean[][] visited;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static ArrayList<Integer> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P2667/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    if (count > 0) {
                        list.add(count);
                        count = 0;
                    }
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int item: list) System.out.println(item);
    }

    static void dfs(int cur_i, int cur_j) {
        visited[cur_i][cur_j] = true;

        if (board[cur_i][cur_j] == 1) {
            count ++;

            for (int t = 0; t < 4; t++) {
                int to_i = cur_i + di[t];
                int to_j = cur_j + dj[t];

                if (isValidPath(to_i, to_j) && !visited[to_i][to_j]) {
                    dfs(to_i, to_j);
                }
            }
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}

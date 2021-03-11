package BFS.swea1953;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M, R, C, L;
    static int[][] map;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/swea1953/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = stoi(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());
            M = stoi(st.nextToken());
            R = stoi(st.nextToken());
            C = stoi(st.nextToken());
            L = stoi(st.nextToken());

            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) map[i][j] = stoi(st.nextToken());
            }

            sb.append("#").append(t).append(" ").append(bfs()).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int bfs() {
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.offer(new Position(R, C));
        visited[R][C] = true;

        int cnt = 1;
        while (!q.isEmpty() && --L > 0) {
            int curSize = q.size();
            while (curSize-- > 0) {
                Position p = q.poll();

                for (int k = 0; k < 4; k++) {
                    if (isValidDir(map[p.i][p.j], k)) {
                        int to_i = p.i + di[k];
                        int to_j = p.j + dj[k];

                        if (isValidPath(to_i, to_j) && !visited[to_i][to_j] && map[to_i][to_j] > 0) {
                            if (isValidDir(map[to_i][to_j], (k+2)%4)) {
                                visited[to_i][to_j] = true;
                                cnt ++;
                                q.offer(new Position(to_i, to_j));
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }

    static boolean isValidDir(int type, int d) {
        if (type == 1 ||
            (type == 2 && (d == 0 || d == 2)) ||
            (type == 3 && (d == 1 || d == 3)) ||
            (type == 4 && (d == 0 || d == 1)) ||
            (type == 5 && (d == 1 || d == 2)) ||
            (type == 6 && (d == 2 || d == 3)) ||
            (type == 7 && (d == 3 || d == 0))
        ) return true;
        else return false;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }

    static int stoi(String s) { return Integer.parseInt(s); }

    static class Position {
        int i, j;

        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

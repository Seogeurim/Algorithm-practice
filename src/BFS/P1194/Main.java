package BFS.P1194;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][][] visited;
    static Queue<Pos> q;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P1194/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][22];
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0') {
                    q.offer(new Pos(i, j, 0, 0, ""));
                    visited[i][j][0] = true;
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int k = 0; k < 4; k++) {
                int to_i = p.i + di[k];
                int to_j = p.j + dj[k];
                if (!isValidPath(to_i, to_j) || map[to_i][to_j] == '#' || visited[to_i][to_j][p.k]) continue;
                if (map[to_i][to_j] == '1') return p.d+1;
                if ('A' <= map[to_i][to_j] && map[to_i][to_j] <= 'F' && p.keys.indexOf(map[to_i][to_j]-'A'+'a') < 0) continue;
                if ('a' <= map[to_i][to_j] && map[to_i][to_j] <= 'f' && p.keys.indexOf(map[to_i][to_j]) < 0) {
                    visited[to_i][to_j][p.k+map[to_i][to_j]-'a'+1] = true;
                    q.offer(new Pos(to_i, to_j, p.k+map[to_i][to_j]-'a'+1, p.d+1, p.keys+map[to_i][to_j]));
                } else {
                    visited[to_i][to_j][p.k] = true;
                    q.offer(new Pos(to_i, to_j, p.k, p.d+1, p.keys));
                }
            }
        }

        return -1;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }

    static class Pos {
        int i, j, k, d;
        String keys;

        public Pos(int i, int j, int k, int d, String keys) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.d = d;
            this.keys = keys;
        }
    }
}

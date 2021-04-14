package BFS.P7576;

import java.io.*;
import java.util.*;

public class Main2 {

    static int M, N, zero, cnt;
    static int[][] map;
    static int[] di = {-1, 0, 1, 0}, dj = {0, 1, 0, -1};
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P7576/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) q.offer(new Pos(i, j, 0));
                else if (map[i][j] == 0) zero ++;
            }
        }

        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int k = 0; k < 4; k++) {
                int to_i = p.i + di[k];
                int to_j = p.j + dj[k];
                if (isValidPath(to_i, to_j) && map[to_i][to_j] == 0) {
                    map[to_i][to_j] = 1;
                    q.offer(new Pos(to_i, to_j, p.d+1));
                    zero --;
                }
            }
            cnt = p.d;
        }

        if (zero > 0) System.out.println(-1);
        else System.out.println(cnt);
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }

    static class Pos {
        int i, j, d;

        public Pos(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
}

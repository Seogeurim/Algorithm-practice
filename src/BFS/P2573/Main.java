package BFS.P2573;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int year = 0;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static Queue<Position> q = new LinkedList<>();
    static int count;
    static boolean[][] visited;
    static int[][] temp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P2573/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) q.offer(new Position(i, j));
            }
        }

        while (true) {
            if (q.isEmpty()) {
                year = 0;
                break;
            }

            visited = new boolean[N][M];
            count = 0;
            find(q.peek());
            if (count != q.size()) break;

            temp = new int[N][M];
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                Position cur = q.poll();
                for (int t = 0; t < 4; t++) {
                    int to_i = cur.i + di[t];
                    int to_j = cur.j + dj[t];

                    if (isValidPath(to_i, to_j) && map[to_i][to_j] == 0)
                        temp[cur.i][cur.j] --;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] += temp[i][j];
                    if (map[i][j] < 0) map[i][j] = 0;
                    if (map[i][j] != 0) q.offer(new Position(i, j));
                }
            }

            year ++;
        }

        System.out.println(year);
    }

    static void find(Position start) {
        visited[start.i][start.j] = true;
        count ++;

        for (int t = 0; t < 4; t++) {
            int to_i = start.i + di[t];
            int to_j = start.j + dj[t];

            if (isValidPath(to_i, to_j) && map[to_i][to_j] != 0 && !visited[to_i][to_j]) {
                find(new Position(to_i, to_j));

            }
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}



class Position {
    int i;
    int j;

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "Position{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
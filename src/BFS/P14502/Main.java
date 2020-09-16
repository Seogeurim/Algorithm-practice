package BFS.P14502;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static int max = 0;
    static Position[] v;
    static Queue<Position> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P14502/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) q.offer(new Position(i, j));
            }
        }

        v = new Position[q.size()];
        int i = 0;
        while (!q.isEmpty()) {
            v[i++] = q.poll();
        }

        makeWall(0);
        System.out.println(max);
    }

    static void makeWall(int count) {
        if (count == 3) {
            virus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    makeWall(count + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    static void virus() {
        for (Position p : v) {
            q.offer(p);
        }

        while (!q.isEmpty()) {
            Position p = q.poll();

            for (int i = 0; i < 4; i++) {
                int to_i = p.i + di[i];
                int to_j = p.j + dj[i];

                if (isValidPath(to_i, to_j) && board[to_i][to_j] == 0) {
                    board[to_i][to_j] = 2;
                    q.offer(new Position(to_i, to_j));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) count ++;
            }
        }

        max = Math.max(max, count);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
            }
        }
        for (Position p : v) {
            board[p.i][p.j] = 2;
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
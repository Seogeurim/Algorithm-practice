package BFS.P2178;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P2178/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(0, 0));
        int move = 0;
        loop: while (!q.isEmpty()) {
            move ++;
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                Position p = q.poll();
                if (p.i == N-1 && p.j == M-1) break loop;

                for (int j = 0; j < 4; j++) {
                    int to_i = p.i + di[j];
                    int to_j = p.j + dj[j];

                    if (isValidPath(to_i, to_j) && board[to_i][to_j] == 1) {
                        q.offer(new Position(to_i, to_j));
                        board[to_i][to_j] = 0;
                    }
                }
            }
        }

        System.out.println(move);
    }

    static boolean isValidPath(int i, int j){
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
package BFS.P13460;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;

    static Queue<Position> q = new LinkedList<>();
    static boolean r_flag = false;
    static boolean b_flag = false;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static boolean[][][][] visited = new boolean[11][11][11][11];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P13460/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        N = Integer.parseInt(line.split(" ")[0]);
        M = Integer.parseInt(line.split(" ")[1]);

        board = new char[N][M];
        int ri = 0, rj = 0, bi = 0, bj = 0;

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    ri = i;
                    rj = j;
                } else if (board[i][j] == 'B') {
                    bi = i;
                    bj = j;
                }
            }
        }

        q.offer(new Position(ri, rj, bi, bj));
        int count = 0;
        boolean success = false;
        loop :
        while (!q.isEmpty() && count <= 10) {
            count ++;
            int curSize = q.size();

            for (int c = 0; c < curSize; c++) {
                Position current = q.poll();
                visited[current.red_i][current.red_j][current.blue_i][current.blue_j] = true;

                for (int t = 0; t < 4; t++) {
                    b_flag = false;
                    r_flag = false;
                    Position to = move(di[t], dj[t], current);

                    if (!b_flag && r_flag) break loop;
                    if (!visited[to.red_i][to.red_j][to.blue_i][to.blue_j] && !b_flag)
                        q.offer(to);
                }
            }
        }

        if (!b_flag && r_flag && count <= 10) System.out.println(count);
        else System.out.println(-1);
    }

    static Position move(int move_i, int move_j, Position p) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (board[i][j] == 'R' || board[i][j] == 'B') board[i][j] = '.';
        }
        board[p.red_i][p.red_j] = 'R';
        board[p.blue_i][p.blue_j] = 'B';

        int r_toi = p.red_i + move_i, r_toj = p.red_j + move_j;
        int b_toi = p.blue_i + move_i, b_toj = p.blue_j + move_j;
        boolean r_end = false, b_end = false;

        while (true) {
            if (r_end && b_end)
                return new Position(r_toi-move_i, r_toj-move_j, b_toi-move_i, b_toj-move_j);

            char red = board[r_toi][r_toj];
            char blue = board[b_toi][b_toj];

            if (!r_end) {
                switch (red) {
                    case '.':
                        board[r_toi-move_i][r_toj-move_j] = '.';
                        board[r_toi][r_toj] = 'R';
                        r_toi += move_i;
                        r_toj += move_j;
                        break;
                    case 'B':
                        if (blue == '#') {
                            r_end = true;
                        } else {
                            board[r_toi-move_i][r_toj-move_j] = '.';
                            board[r_toi][r_toj] = 'R';
                            r_toi += move_i;
                            r_toj += move_j;
                        }
                        break;
                    case '#':
                        r_end = true;
                        break;
                    case 'O':
                        r_flag = true;
                        r_end = true;
                        break;
                }
            }

            if (!b_end) {
                switch (blue) {
                    case '.':
                        board[b_toi-move_i][b_toj-move_j] = '.';
                        board[b_toi][b_toj] = 'B';
                        b_toi += move_i;
                        b_toj += move_j;
                        break;
                    case 'R':
                        if (red == '#') {
                            b_end = true;
                        } else {
                            board[b_toi-move_i][b_toj-move_j] = '.';
                            board[b_toi][b_toj] = 'B';
                            b_toi += move_i;
                            b_toj += move_j;
                        }
                        break;
                    case '#':
                        b_end = true;
                        break;
                    case 'O':
                        b_flag = true;
                        b_end = true;
                        break;
                }
            }
        }
    }
}

class Position {
    int red_i;
    int red_j;
    int blue_i;
    int blue_j;

    public Position(int red_i, int red_j, int blue_i, int blue_j) {
        this.red_i = red_i;
        this.red_j = red_j;
        this.blue_i = blue_i;
        this.blue_j = blue_j;
    }

    @Override
    public String toString() {
        return "Position{" +
                "red_i=" + red_i +
                ", red_j=" + red_j +
                ", blue_i=" + blue_i +
                ", blue_j=" + blue_j +
                '}';
    }
}
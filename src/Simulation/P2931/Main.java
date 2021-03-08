package Simulation.P2931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] map;

    static Position M, Z;
    static boolean[][] visited;
    static int visited_cnt;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static int ans_i, ans_j;
    static int[] ans_d = new int[4];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P2931/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'M') M = new Position(i, j, -1);
                else if (map[i][j] == 'Z') Z = new Position(i, j, -1);
                if (map[i][j] != '.') visited_cnt++;
            }
        }

        search(M);
        search(Z);
        System.out.println(++ans_i + " " + ++ans_j + " " + getBlock());
    }

    static char getBlock() {
        if (visited_cnt > 0) return '+';
        if (ans_d[1] == 1 && ans_d[2] == 1) return '1';
        else if (ans_d[0] == 1 && ans_d[1] == 1) return '2';
        else if (ans_d[0] == 1 && ans_d[3] == 1) return '3';
        else if (ans_d[2] == 1 && ans_d[3] == 1) return '4';
        else if (ans_d[0] == 1 || ans_d[2] == 1) return '|';
        else return '-';
    }

    static void search(Position p) {
        if (!visited[p.i][p.j]) {
            visited[p.i][p.j] = true;
            visited_cnt --;
        }

        if (p.d == -1) {
            for (int d = 0; d < 4; d++) {
                Position to = move(p, d);
                if (to != null) search(to);
            }
        }

        int to_d = getMoveDirection(p, map[p.i][p.j]);
        Position to = move(p, to_d);
        if (to != null) search(to);
    }

    static Position move(Position p, int to_d) {
        if (to_d == -1) return null;

        int to_i = p.i + di[to_d];
        int to_j = p.j + dj[to_d];

        if (!isValidPath(to_i, to_j)) return null;
        if (map[to_i][to_j] == '.' && map[p.i][p.j] != 'M' && map[p.i][p.j] != 'Z') {
            if (p.d != -1) {
                ans_i = to_i;
                ans_j = to_j;
                ans_d[(to_d+2)%4] ++;
            } else if (to_i == ans_i && to_j == ans_j) {
                ans_d[(to_d+2)%4] ++;
            }
            return null;
        }

        return new Position(to_i, to_j, to_d);
    }

    static int getMoveDirection(Position p, char block) {
        if (block == '|' || block == '-' || block == '+') {
            return p.d;
        } else if (block == '1') {
            if (p.d == 3) return 2;
            else if (p.d == 0) return 1;
        } else if (block == '2') {
            if (p.d == 2) return 1;
            else if (p.d == 3) return 0;
        } else if (block == '3') {
            if (p.d == 1) return 0;
            else if (p.d == 2) return 3;
        } else if (block == '4') {
            if (p.d == 1) return 2;
            else if (p.d == 0) return 3;
        }
        return -1;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < R && 0 <= j && j < C;
    }

    static class Position {
        int i, j, d;

        public Position(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
}

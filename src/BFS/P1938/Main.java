package BFS.P1938;

import java.io.*;
import java.util.*;

public class Main {

    final static int col = 0, row = 1;
    static int N;
    static char[][] map;
    static Position start, dest;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P1938/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N+2][N+2];
        for (int i = 0; i < N+2; i++) Arrays.fill(map[i], '1');
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = line.charAt(j-1);
                if (map[i][j] == 'B') start = setPosition(start, i, j);
                else if (map[i][j] == 'E') dest = setPosition(dest, i, j);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Position> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N+2][N+2][2];
        int cnt = 0;

        q.offer(start);
        visited[start.i][start.j][start.d] = true;
        while (!q.isEmpty()) {
            int curSize = q.size();
            while (curSize-- > 0) {
                Position cur = q.poll();
                if (cur.equals(dest)) return cnt;

                Position to;
                to = moveUp(cur);
                if (to != null && !visited[to.i][to.j][to.d]) {
                    visited[to.i][to.j][to.d] = true;
                    q.offer(to);
                }
                to = moveDown(cur);
                if (to != null && !visited[to.i][to.j][to.d]) {
                    visited[to.i][to.j][to.d] = true;
                    q.offer(to);
                }
                to = moveLeft(cur);
                if (to != null && !visited[to.i][to.j][to.d]) {
                    visited[to.i][to.j][to.d] = true;
                    q.offer(to);
                }
                to = moveRight(cur);
                if (to != null && !visited[to.i][to.j][to.d]) {
                    visited[to.i][to.j][to.d] = true;
                    q.offer(to);
                }
                to = rotate(cur);
                if (to != null && !visited[to.i][to.j][to.d]) {
                    visited[to.i][to.j][to.d] = true;
                    q.offer(to);
                }
            }
            cnt ++;
        }
        return 0;
    }

    static Position moveUp(Position p) {
        if (p.d == col) {
            if (map[p.i-1][p.j] == '1') return null;
        } else if (map[p.i-1][p.j] == '1' || map[p.i-1][p.j+1] == '1' || map[p.i-1][p.j+2] == '1') return null;
        return new Position(p.i-1, p.j, p.d);
    }

    static Position moveDown(Position p) {
        if (p.d == col) {
            if (map[p.i+3][p.j] == '1') return null;
        } else if (map[p.i+1][p.j] == '1' || map[p.i+1][p.j+1] == '1' || map[p.i+1][p.j+2] == '1') return null;
        return new Position(p.i+1, p.j, p.d);
    }

    static Position moveLeft(Position p) {
        if (p.d == row) {
            if (map[p.i][p.j-1] == '1') return null;
        } else if (map[p.i][p.j-1] == '1' || map[p.i+1][p.j-1] == '1' || map[p.i+2][p.j-1] == '1') return null;
        return new Position(p.i, p.j-1, p.d);
    }

    static Position moveRight(Position p) {
        if (p.d == row) {
            if (map[p.i][p.j+3] == '1') return null;
        } else if (map[p.i][p.j+1] == '1' || map[p.i+1][p.j+1] == '1' || map[p.i+2][p.j+1] == '1') return null;
        return new Position(p.i, p.j+1, p.d);
    }

    static Position rotate(Position p) {
        if (p.d == col) {
            if (map[p.i][p.j-1] == '1' || map[p.i][p.j+1] == '1' ||
                    map[p.i+1][p.j-1] == '1' || map[p.i+1][p.j+1] == '1' ||
                    map[p.i+2][p.j-1] == '1' || map[p.i+2][p.j+1] == '1') {
                return null;
            }
            return new Position(p.i+1, p.j-1, row);
        } else {
            if (map[p.i-1][p.j] == '1' || map[p.i+1][p.j] == '1' ||
                    map[p.i-1][p.j+1] == '1' || map[p.i+1][p.j+1] == '1' ||
                    map[p.i-1][p.j+2] == '1' || map[p.i+1][p.j+2] == '1') {
                return null;
            }
            return new Position(p.i-1, p.j+1, col);
        }
    }

    static Position setPosition(Position p, int i, int j) {
        if (p == null) p = new Position(i, j, 0);
        else if (p.j == j) p.d = col;
        else p.d = row;
        return p;
    }

    static class Position {
        int i, j, d;

        public Position(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            Position p = (Position) o;
            return i == p.i && j == p.j && d == p.d;
        }
    }
}

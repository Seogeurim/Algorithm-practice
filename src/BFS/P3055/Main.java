package BFS.P3055;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;
    static Position dest;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static Queue<Position> water = new LinkedList<>();
    static Queue<Position> dochi = new LinkedList<>();

    static int time = 0;
    static boolean found = false;
    static int ans = -1;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P3055/input1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (line.charAt(j) == 'D') dest = new Position(i, j);
                else if (line.charAt(j) == 'S') dochi.offer(new Position(i, j));
                else if (line.charAt(j) == '*') water.offer(new Position(i, j));
            }
        }

        bfs();

        if (!found) System.out.println("KAKTUS");
        else System.out.println(ans);
    }

    static void bfs() {
        while (!dochi.isEmpty()) {

            if (!water.isEmpty()) {
                int curSize = water.size();
                for (int i = 0; i < curSize; i++) {
                    Position current = water.poll();
                    for (int t = 0; t < 4; t++) {
                        int to_i = current.i + di[t];
                        int to_j = current.j + dj[t];

                        if (isValidPath(to_i, to_j) && (map[to_i][to_j] == '.'|| map[to_i][to_j] == 'S')) {
                            map[to_i][to_j] = '*';
                            water.offer(new Position(to_i, to_j));
                        }
                    }
                }
            }

            int curSize = dochi.size();
            for (int i = 0; i < curSize; i++) {
                Position current = dochi.poll();

                if (current.i == dest.i && current.j == dest.j) {
                    found = true;
                    if (ans == -1) ans = time;
                    else ans = Math.min(ans, time);
                }

                for (int t = 0; t < 4; t++) {
                    int to_i = current.i + di[t];
                    int to_j = current.j + dj[t];

                    if (isValidPath(to_i, to_j) && (map[to_i][to_j] == '.' || map[to_i][to_j] == 'D')) {
                        map[to_i][to_j] = 'S';
                        dochi.offer(new Position(to_i, to_j));
                    }
                }
            }

            time ++;
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < R && 0 <= j && j < C;
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

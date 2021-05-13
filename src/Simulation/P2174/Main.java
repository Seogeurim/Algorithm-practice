package Simulation.P2174;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, N, M;
    static int[][] map;
    static Pos[] robots;
    static StringBuilder sb;

    static String dirs = "NESW";
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P2174/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[A+1][B+1];
        robots = new Pos[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            robots[i] = new Pos(x, y, dirs.indexOf(d));
            map[x][y] = i;
        }

        sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int robot = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());
            if (sb.length() > 0) continue;
            simulation(robot, cmd, repeat);
        }

        if (sb.length() == 0) System.out.println("OK");
        else System.out.println(sb.toString());
    }

    static void simulation(int robot, char cmd, int repeat) {
        if (cmd == 'L') {
            repeat %= 4;
            int new_d = robots[robot].d - repeat;
            robots[robot].d = new_d < 0 ? new_d + 4 : new_d;
        } else if (cmd == 'R') {
            repeat %= 4;
            int new_d = robots[robot].d + repeat;
            robots[robot].d = new_d > 3 ? new_d - 4 : new_d;
        } else { // F
            Pos r = robots[robot];
            int nx = r.x, ny = r.y;
            while (repeat-- > 0) {
                nx += dx[r.d];
                ny += dy[r.d];
                if (!isValidPath(nx, ny)) {
                    sb.append("Robot ").append(robot).append(" crashes into the wall");
                    return;
                }
                if (map[nx][ny] > 0) {
                    sb.append("Robot ").append(robot).append(" crashes into robot ").append(map[nx][ny]);
                    return;
                }
            }
            robots[robot] = new Pos(nx, ny, r.d);
            map[r.x][r.y] = 0;
            map[nx][ny] = robot;
        }
    }

    static boolean isValidPath(int x, int y) {
        return 1 <= x && x <= A && 1 <= y && y <= B;
    }

    static class Pos {
        int x, y, d;

        public Pos(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}

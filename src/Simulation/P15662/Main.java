package Simulation.P15662;

import java.io.*;
import java.util.*;

public class Main {

    final static int R = 2, L = 6;
    final static int clock = 1, rev_clock = -1;

    static String[] wheels;
    static Queue<Direction> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P15662/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        wheels = new String[T];
        for (int i = 0; i < T; i++) wheels[i] = br.readLine();

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            q.offer(new Direction(idx, dir));
            int cur_dir = dir;
            for (int i = idx; i < T-1; i++) {
                cur_dir *= -1;
                if (wheels[i].charAt(R) == wheels[i+1].charAt(L)) break;
                else q.offer(new Direction(i+1, cur_dir));
            }
            cur_dir = dir;
            for (int i = idx; i > 0; i--) {
                cur_dir *= -1;
                if (wheels[i-1].charAt(R) == wheels[i].charAt(L)) break;
                else q.offer(new Direction(i-1, cur_dir));
            }

            while (!q.isEmpty()) {
                Direction d = q.poll();
                rotate(d.idx, d.dir);
            }
        }

        int S_count = 0;
        for (int i = 0; i < T; i++) S_count += wheels[i].charAt(0) - '0';
        System.out.println(S_count);
    }

    static void rotate(int idx, int dir) {
        String w = wheels[idx];
        if (dir == clock) wheels[idx] = w.charAt(w.length()-1) + w.substring(0, w.length()-1);
        else if (dir == rev_clock) wheels[idx] = w.substring(1) + w.charAt(0);
    }

    static class Direction {
        int idx;
        int dir;

        public Direction(int idx, int dir) {
            this.idx = idx;
            this.dir = dir;
        }
    }
}

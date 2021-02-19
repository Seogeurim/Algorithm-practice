package Simulation.P17135;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, D, max;
    static int[][] map;
    static int[] shooter = new int[3];
    static ArrayList<Pos> enemies = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P17135/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N+1][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        placeShooter(0, 0);
        System.out.println(max);
    }

    static void initEnemies() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) enemies.add(new Pos(i, j));
            }
        }
    }

    static void placeShooter(int idx, int cnt) {
        if (cnt == 3) {
            initEnemies();
            play();
            return;
        }

        for (int i = idx; i < M; i++) {
            if (map[N][i] == 0) {
                shooter[cnt] = i;
                placeShooter(i+1, cnt+1);
            }
        }
    }

    static void play() {
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o1.dist == o2.dist ? o1.j-o2.j : o1.dist-o2.dist);
        HashSet<Pos> kill = new HashSet<>();
        int cnt = 0;
        while (!enemies.isEmpty()) {
            for (int s : shooter) {
                for (Pos e : enemies) {
                    if (e.setDist(N, s) <= D) pq.offer(e);
                }
                if (!pq.isEmpty()) kill.add(pq.poll());
                pq.clear();
            }
            for (Pos k : kill) {
                enemies.remove(k);
                cnt++;
            }
            kill.clear();

            for (int i = 0; i < enemies.size(); i++) {
                if (enemies.get(i).i+1 == N) enemies.remove(i--);
                else enemies.get(i).i ++;
            }
        }
        max = Math.max(max, cnt);
    }

    static class Pos {
        int i, j, dist;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int setDist(int r, int c) {
            dist = Math.abs(i-r) + Math.abs(j-c);
            return dist;
        }
    }
}

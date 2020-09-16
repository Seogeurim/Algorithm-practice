package BFS.P16236;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] space;

    static Position baby;
    static int fish_size = 2;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P16236/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        space = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    baby = new Position(i, j);
                    space[i][j] = 0;
                }
            }
        }

        int time = 0;
        int count = 0;
        while (true) {
            int t = checkFish();
            if (t == 0) break;
            else {
                time += t;
                count ++;
                if (count == fish_size) {
                    fish_size ++;
                    count = 0;
                }
            }
        }

        System.out.println(time);
    }

    static int checkFish(){
        int min = 0;
        Position eat = new Position(0, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (0 < space[i][j] && space[i][j] < fish_size) {
                    int path = calPath(baby, new Position(i, j));
//                    System.out.println(path);
                    if (min == 0 || (min > path && path != 0)) {
                        min = path;
                        eat = new Position(i, j);
                    }
                }
            }
        }

//        System.out.println(min + " " + fish_size);
        if (min != 0) {
            space[eat.i][eat.j] = 0;
            baby = eat;
        }
        return min;
    }

    static int calPath(Position start, Position end) {
//        System.out.println(fish_size + " " + start + " " + end);
        int path = 0;
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(start);
        visited[start.i][start.j] = true;
        while(!q.isEmpty()) {
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                Position p = q.poll();
                if (p.i == end.i && p.j == end.j) return path;

                for (int j = 0; j < 4; j++) {
                    int to_i = p.i + di[j];
                    int to_j = p.j + dj[j];

                    if (isValidPath(to_i, to_j) && !visited[to_i][to_j] && space[to_i][to_j] <= fish_size) {
                        q.offer(new Position(to_i, to_j));
                        visited[to_i][to_j] = true;
                    }
                }
            }
            path ++;
        }
        return 0;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
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
        return "Position{" + "i=" + i + ", j=" + j + '}';
    }
}
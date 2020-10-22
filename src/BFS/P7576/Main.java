package BFS.P7576;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] box;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static Queue<Position> q = new LinkedList<>();
    static int ans = -1;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P7576/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) q.offer(new Position(i, j));
            }
        }

        while (!q.isEmpty()) {
            ans ++;
            if (checkDone()) break;

            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                Position cur = q.poll();
                for (int t = 0; t < 4; t++) {
                    int to_i = cur.i + di[t];
                    int to_j = cur.j + dj[t];

                    if (isValidPath(to_i, to_j) && box[to_i][to_j] == 0) {
                        box[to_i][to_j] = 1;
                        q.offer(new Position(to_i, to_j));
                    }
                }
            }
        }

        if (!checkDone()) System.out.println(-1);
        else System.out.println(ans);
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }

    static boolean checkDone() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) return false;
            }
        }
        return true;
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
package Impl.P21608;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map, like;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Impl/P21608/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        like = new int[N*N+1][4];

        for (int i = 0; i < N*N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) like[s][j] = Integer.parseInt(st.nextToken());
            setSeat(s);
        }

        int score = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int to_i = i + di[k];
                    int to_j = j + dj[k];
                    if (!isValidPath(to_i, to_j)) continue;
                    for (int l = 0; l < 4; l++) {
                        if (map[to_i][to_j] == like[map[i][j]][l]) {
                            cnt ++;
                            break;
                        }
                    }
                }
                score += getScore(cnt);
            }
        }

        System.out.println(score);
    }

    static void setSeat(int student) {
        PriorityQueue<Seat> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) continue;
                Seat s = new Seat(i, j);
                for (int k = 0; k < 4; k++) {
                    int to_i = i + di[k];
                    int to_j = j + dj[k];
                    if (!isValidPath(to_i, to_j)) continue;
                    if (map[to_i][to_j] == 0) {
                        s.emptyCnt ++;
                        continue;
                    }
                    for (int l = 0; l < 4; l++) {
                        if (map[to_i][to_j] == like[student][l]) {
                            s.likeCnt ++;
                            break;
                        }
                    }
                }
                pq.offer(s);
            }
        }
        Seat target = pq.poll();
        map[target.i][target.j] = student;
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }

    static int getScore(int cnt) {
        if (cnt == 2) return 10;
        else if (cnt == 3) return 100;
        else if (cnt == 4) return 1000;
        else return cnt;
    }

    static class Seat implements Comparable<Seat> {
        int i, j, emptyCnt, likeCnt;

        public Seat(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Seat o) {
            if (this.likeCnt == o.likeCnt) {
                if (this.emptyCnt == o.emptyCnt) {
                    if (this.i == o.i) return Integer.compare(this.j, o.j);
                    return Integer.compare(this.i, o.i);
                }
                return Integer.compare(o.emptyCnt, this.emptyCnt);
            }
            return Integer.compare(o.likeCnt, this.likeCnt);
        }
    }
}

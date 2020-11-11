package _2020_KAKAO_BLIND_RECRUITMENT.P7;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[][]{{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}}));
    }
}

class Solution {

    static int N;
    static int[][] my_board;
    static boolean[][][] visited;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int[] rot = {-1, 1};

    public int solution(int[][] board) {
        N = board.length;
        my_board = board;
        visited = new boolean[N][N][2];

        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(new int[]{0, 0}, new int[]{0, 1}, 0));
        while (!q.isEmpty()) {
            Position cur = q.poll();
            int cur_dir = (cur.fir[0] == cur.sec[0]) ? 0 : 1;
            visited[cur.fir[0]][cur.fir[1]][cur_dir] = true;

            for (int t = 0; t < 4; t++) {
                int[] fir_to = new int[]{cur.fir[0] + di[t], cur.fir[1] + dj[t]};
                int[] sec_to = new int[]{cur.sec[0] + di[t], cur.sec[1] + dj[t]};

                if (isValidPath(fir_to[0], fir_to[1]) && isValidPath(sec_to[0], sec_to[1])
                    && !visited[fir_to[0]][fir_to[1]][cur_dir]) {
                    if ((fir_to[0] == N-1 && fir_to[1] == N-1) || (sec_to[0] == N-1 && sec_to[1] == N-1)) return cur.time + 1;
                    q.offer(new Position(fir_to, sec_to, cur.time + 1));
                }
            }

            for (int t = 0; t < 2; t++) {
                int[] fir_to, sec_to;
                int to_dir = (cur_dir == 0) ? 1 : 0;

                if (cur.fir[0] == cur.sec[0]) {
                    fir_to = new int[]{cur.fir[0] + rot[t], cur.fir[1]};
                    sec_to = new int[]{cur.sec[0] + rot[t], cur.sec[1]};
                } else {
                    fir_to = new int[]{cur.fir[0], cur.fir[1] + rot[t]};
                    sec_to = new int[]{cur.sec[0], cur.sec[1] + rot[t]};
                }

                if (isValidPath(fir_to[0], fir_to[1]) && isValidPath(sec_to[0], sec_to[1])
                    && !visited[cur.fir[0]][cur.fir[1]][to_dir] && !visited[cur.sec[0]][cur.sec[1]][to_dir]) {
                    if ((fir_to[0] == N-1 && fir_to[1] == N-1) || (sec_to[0] == N-1 && sec_to[1] == N-1)) return cur.time + 1;
                    q.offer(new Position(cur.fir, fir_to, cur.time + 1));
                    q.offer(new Position(cur.sec, sec_to, cur.time + 1));
                }
            }
        }

        return 0;
    }

    private static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N && my_board[i][j] == 0;
    }
}

class Position {
    int[] fir;
    int[] sec;
    int time;

    public Position(int[] fir, int[] sec, int time) {
        this.fir = fir;
        this.sec = sec;
        this.time = time;
    }
}
package BFS.swea10966;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M;
    static char[][] map;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/swea10966/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            Queue<int[]> q = new LinkedList<>();
            int[][] dist = new int[N][M];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == 'W') {
                        q.offer(new int[]{i, j});
                        dist[i][j] = 1;
                    }
                }
            }

            int ans = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int now_dist = dist[cur[0]][cur[1]];

                for (int k = 0; k < 4; k++) {
                    int to_i = cur[0] + di[k];
                    int to_j = cur[1] + dj[k];

                    if (isValidPath(to_i, to_j) && dist[to_i][to_j] == 0) {
                        dist[to_i][to_j] = now_dist + 1;
                        q.offer(new int[]{to_i, to_j});
                        ans += now_dist;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}

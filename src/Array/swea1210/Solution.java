package Array.swea1210;

import java.io.*;
import java.util.*;

public class Solution {

    final static int T = 10, N = 100;
    static int[][] ladder;
    static int[] current;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Array/swea1210/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= T; t++) {
            br.readLine();
            ladder = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if (ladder[i][j] == 2) current = new int[]{i, j};
                }
            }

            while (current[0] >= 0) {
                boolean rotated = false;
                for (int d = -1; d <= 1 && !rotated; d += 2) {
                    while (0 <= current[1]+d && current[1]+d < N && ladder[current[0]][current[1]+d] == 1) {
                        rotated = true;
                        current[1] += d;
                    }
                }
                current[0] --;
            }

            System.out.println("#" + t  + " " + current[1]);
        }
    }
}

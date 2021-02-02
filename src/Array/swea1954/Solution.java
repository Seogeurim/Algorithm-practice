package Array.swea1954;

import java.io.*;

public class Solution {

    static int T, N;
    static int[][] arr;

    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Array/swea1954/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            int num = 1;
            int i = 0, j = 0, dir = 0;
            while (num <= N*N) {
                arr[i][j] = num++;
                if (!canGo(i + di[dir % 4], j + dj[dir % 4])) dir ++;
                i += di[dir % 4];
                j += dj[dir % 4];
            }

            System.out.println("#" + t);
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    static boolean canGo(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N && arr[i][j] == 0;
    }
}

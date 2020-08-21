package DP.P11660;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P11660/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (j == 0) nums[i][j] = Integer.parseInt(st.nextToken());
                else nums[i][j] = nums[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int ans = 0;
            for (int j = x1; j <= x2; j++) {
                if (y1 > 0) ans += nums[j][y2] - nums[j][y1 - 1];
                else ans += nums[j][y2];
            }
            System.out.println(ans);
        }
    }
}

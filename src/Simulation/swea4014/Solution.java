package Simulation.swea4014;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, X, ans;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/swea4014/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            ans = 0;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                if (check(map[i])) ans ++;
            }
            for (int j = 0; j < N; j++) {
                int[] arr = new int[N];
                for (int i = 0; i < N; i++) arr[i] = map[i][j];
                if (check(arr)) ans ++;
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean check(int[] arr) {
        int cnt = 1, cur = arr[0], max = cur;
        for (int i = 1; i < N; i++) {
            if (arr[i] == cur) cnt++;
            else {
                if (Math.abs(arr[i]-cur) > 1) return false;
                if (arr[i] > max) {
                    if (cnt < X) return false;
                    max = arr[i];
                } else if (arr[i] > cur) {
                    if (cnt < X*2) return false;
                    max = arr[i];
                } else {
                    if (cur < max && cnt < X) return false;
                }
                cnt = 1;
                cur = arr[i];
            }
        }
        return cur == max || cnt >= X;
    }
}

package DFS.swea5215;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, L, max;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/swea5215/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            search(0, 0, 0);

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void search(int score, int cal, int idx) {
        if (idx == N) {
            if (cal <= L) max = Math.max(max, score);
            return;
        }

        search(score + arr[idx][0], cal + arr[idx][1], idx + 1);
        search(score, cal, idx+1);
    }
}

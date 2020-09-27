package DFS.P14501;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] schedule;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P14501/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(ans);
    }

    static void dfs(int start, int sum) {
        if (start == N) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = start; i < N; i++) {
            int to = i + schedule[i][0] - 1;
            if (to < N) {
                dfs(to + 1, sum + schedule[i][1]);
            } else {
                ans = Math.max(ans, sum);
            }
        }
    }
}

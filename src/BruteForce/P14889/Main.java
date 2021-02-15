package BruteForce.P14889;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, ans = Integer.MAX_VALUE;
    static int[][] S;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BruteForce/P14889/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) S[i][j] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N+1];
        visited[1] = true;
        comb(2, 1);

        System.out.println(ans);
    }

    static void comb(int s, int cnt) {
        if (cnt == N/2) {
            calc();
            return;
        }

        for (int i = s; i <= N; i++) {
            visited[i] = true;
            comb(i+1, cnt+1);
            visited[i] = false;
        }
    }

    static void calc() {
        int s1 = 0, s2 = 0;
        int[] t1 = new int[N/2], t2 = new int[N/2];

        for (int i = 1, k = 0, l = 0; i <= N; i++) {
            if (visited[i]) t1[k++] = i;
            else t2[l++] = i;
        }

        for (int i = 0; i < N/2-1; i++) {
            for (int j = i; j < N/2; j++) {
                s1 += S[t1[i]][t1[j]] + S[t1[j]][t1[i]];
                s2 += S[t2[i]][t2[j]] + S[t2[j]][t2[i]];
            }
        }

        ans = Math.min(ans, Math.abs(s1-s2));
    }
}

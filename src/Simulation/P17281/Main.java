package Simulation.P17281;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, ans;
    static int[][] game;
    static int[] order = new int[10];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P17281/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        game = new int[N][10];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) game[i][j] = Integer.parseInt(st.nextToken());
        }

        order[4] = 1;
        perm(1, 0);

        System.out.println(ans);
    }

    static void perm(int cnt, int mask) {
        if (cnt == 4) cnt ++;
        if (cnt == 10) {
            ans = Math.max(ans, play());
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if ((mask & 1<<i) != 0) continue;
            order[cnt] = i;
            perm(cnt+1, mask | 1<<i);
        }
    }

    static int play() {
        int runner = 1, score = 0;
        for (int i = 0; i < N; i++) {
            int r1 = 0, r2 = 0, r3 = 0, home = 0, out = 0;
            while (out < 3) {
                switch (game[i][order[runner]]) {
                    case 1:
                        home += r3;
                        r3 = r2;
                        r2 = r1;
                        r1 = 1;
                        break;
                    case 2:
                        home += r3 + r2;
                        r3 = r1;
                        r2 = 1;
                        r1 = 0;
                        break;
                    case 3:
                        home += r3 + r2 + r1;
                        r3 = 1;
                        r2 = r1 = 0;
                        break;
                    case 4:
                        home += r3 + r2 + r1 + 1;
                        r3 = r2 = r1 = 0;
                        break;
                    case 0:
                        out ++;
                        break;
                }
                runner ++;
                if (runner == 10) runner = 1;
            }
            score += home;
        }
        return score;
    }
}

package DAC.P1992;

import java.io.*;

public class Main {

    static int N;
    static char[][] map;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAC/P1992/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        solve(0, 0, N);
        System.out.println(sb.toString());
    }

    static void solve(int s_i, int s_j, int n) {
        char c = map[s_i][s_j];
        for (int i = s_i; i < s_i+n; i++) {
            for (int j = s_j; j < s_j+n; j++) {
                if (map[i][j] != c) {
                    sb.append("(");
                    solve(s_i, s_j, n/2);
                    solve(s_i, s_j+n/2, n/2);
                    solve(s_i+n/2, s_j, n/2);
                    solve(s_i+n/2, s_j+n/2, n/2);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(c);
    }
}

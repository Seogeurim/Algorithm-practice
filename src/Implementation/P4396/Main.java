package Implementation.P4396;

import java.io.*;

public class Main {

    static int n;
    static char[][] mine, open;
    static int[] di = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dj = {0, 1, 0, -1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Implementation/P4396/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        mine = new char[n][n];
        open = new char[n][n];

        for (int i = 0; i < n; i++) mine[i] = br.readLine().toCharArray();
        boolean lose = false;
        for (int i = 0; i < n; i++) {
            open[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (open[i][j] == '.') continue;
                if (mine[i][j] == '*') lose = true;
                else open[i][j] = count(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lose && mine[i][j] == '*') open[i][j] = '*';
                System.out.print(open[i][j]);
            }
            System.out.println();
        }
    }

    static char count(int i, int j) {
        int cnt = 0;

        for (int k = 0; k < 8; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
            if (mine[ni][nj] == '*') cnt ++;
        }

        return (char) (cnt + '0');
    }
}

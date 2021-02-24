package Simulation.P10163;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, x, y, w, h;
    static int[][] map = new int[102][102];
    static int[] area;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P10163/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int i = y; i < y+h; i++) {
                for (int j = x; j < x+w; j++) {
                    map[i][j] = n;
                }
            }
        }

        area = new int[N+1];
        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                area[map[i][j]] ++;
            }
        }

        for (int i = 1; i <= N; i++) System.out.println(area[i]);
    }
}

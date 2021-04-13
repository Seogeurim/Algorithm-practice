package Simulation.P2564;

import java.io.*;
import java.util.*;

public class Main {

    static int W, H, N, sum;
    static int[] pos;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P2564/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        pos = new int[N+1];
        for (int i = 0; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (d == 1) pos[i] = k;
            else if (d == 2) pos[i] = 2*W+H-k;
            else if (d == 3) pos[i] = 2*(W+H)-k;
            else pos[i] = W+k;
        }

        int x = pos[N];
        for (int i = 0; i < N; i++) {
            int dist = Math.abs(x-pos[i]);
            sum += Math.min(dist, 2*(W+H)-dist);
        }

        System.out.println(sum);
    }
}

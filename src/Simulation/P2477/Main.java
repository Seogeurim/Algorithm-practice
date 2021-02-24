package Simulation.P2477;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K, D, L, W, H, w, h, sub = 1;
    static int[] edges = new int[6];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P2477/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            if (D <= 2 && W < L) { W = L; w = i; }
            else if (D >= 3 && H < L) { H = L; h = i; }
            edges[i] = L;
        }

        edges[w] = edges[h] = 0;
        edges[getIdx(w-1)] = edges[getIdx(w+1)] = 0;
        edges[getIdx(h-1)] = edges[getIdx(h+1)] = 0;

        for (int i = 0; i < 6; i++) {
            if (edges[i] != 0) sub *= edges[i];
        }

        System.out.println((W*H - sub) * K);
    }

    static int getIdx(int i) {
        if (i < 0) return i+6;
        if (i >= 6) return i-6;
        return i;
    }
}
package Simulation.P14891;

import java.io.*;
import java.util.*;

public class Main {

    final static int R = 2, L = 6;
    static String[] wheel = new String[4];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P14891/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) wheel[i] = br.readLine();
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            
            int[] dirs = new int[4];
            dirs[idx] = dir;
            for (int i = idx; i < 3; i++) {
                if (wheel[i].charAt(R) != wheel[i+1].charAt(L))
                    dirs[i+1] = dirs[i] * (-1);
            }
            for (int i = idx; i > 0; i--) {
                if (wheel[i].charAt(L) == wheel[i-1].charAt(R)) break;
                else dirs[i-1] = dirs[i] * (-1);
            }

            for (int i = 0; i < 4; i++) {
                if (dirs[i] != 0) rotate(i, dirs[i]);
            }
        }

        int ans = 0;
        for (int i = 0; i < 4; i++) ans += (wheel[i].charAt(0) - '0') * Math.pow(2, i);
        System.out.println(ans);
    }

    static void rotate(int idx, int dir) {
        String s = wheel[idx];
        if (dir == 1) wheel[idx] = s.charAt(s.length()-1) + s.substring(0, s.length()-1);
        else if (dir == -1) wheel[idx] = s.substring(1) + s.charAt(0);
    }
}

package Simulation.P1244;

import java.io.*;
import java.util.*;

public class Main {

    static int N, S;
    static int[] switches;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P1244/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        switches = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) switches[i] = Integer.parseInt(st.nextToken());

        S = Integer.parseInt(br.readLine());
        while (S-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int i = num; i <= N; i += num) changeSwitch(i);
            } else if (gender == 2) {
                changeSwitch(num);
                int i = 1;
                while (0 < num-i && num+i <= N) {
                    if (switches[num-i] == switches[num+i]) {
                        changeSwitch(num-i);
                        changeSwitch(num+i);
                        i++;
                    } else break;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }

    static void changeSwitch(int i) {
        switches[i] = switches[i] == 0 ? 1 : 0;
    }
}

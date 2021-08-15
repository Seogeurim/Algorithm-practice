package Greedy.P1092;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, time = 0;
    static List<Integer> crane, box;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Greedy/P1092/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        crane = new ArrayList<>();
        box = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) crane.add(Integer.parseInt(st.nextToken()));
        crane.sort(Collections.reverseOrder());

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) box.add(Integer.parseInt(st.nextToken()));
        box.sort(Collections.reverseOrder());

        if (crane.get(0) < box.get(0)) System.out.println(-1);
        else {
            while (!box.isEmpty()) {
                int m = 0;
                for (int i = 0; i < N;) {
                    if (m == box.size()) break;
                    else if (box.get(m) > crane.get(i)) m ++;
                    else {
                        box.remove(m);
                        i++;
                    }
                }
                time ++;
            }
            System.out.println(time);
        }
    }
}

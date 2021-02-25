package Iterations.swea5356;

import java.io.*;

public class Solution {

    static int T;
    static String[] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Iterations/swea5356/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            map = new String[5];
            for (int i = 0; i < 5; i++) map[i] = br.readLine();

            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i < map[j].length()) {
                        sb.append(map[j].charAt(i));
                    }
                }
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

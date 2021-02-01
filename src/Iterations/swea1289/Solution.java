package Iterations.swea1289;

import java.io.*;

public class Solution {

    static int T;
    static String input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Iterations/swea1289/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            input = br.readLine();
            int cnt = 0;
            char cursor = '0';
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == cursor) continue;
                cursor = (cursor == '0') ? '1' : '0';
                cnt ++;
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}

package Greedy.P1343;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Greedy/P1343/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(br.readLine()));
    }

    static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == 'X') cnt ++;
            else if (cnt > 0) return "-1";
            else sb.append(".");
            if (cnt == 4) {
                sb.append("AAAA");
                cnt = 0;
            } else if ((i == len-1 && cnt == 2) || (i < len-1 && s.charAt(i+1) != 'X' && cnt == 2)) {
                sb.append("BB");
                cnt = 0;
            }
        }
        return cnt > 0 ? "-1" : sb.toString();
    }
}

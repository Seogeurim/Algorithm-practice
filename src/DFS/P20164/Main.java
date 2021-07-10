package DFS.P20164;

import java.io.*;

public class Main {

    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P20164/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dfs(br.readLine(), 0);
        System.out.println(min + " " + max);
    }

    static void dfs(String s, int cnt) {
        int len = s.length();
        cnt += getOdds(s, len);
        if (len == 1) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        } else if (len == 2) {
            int n = Integer.parseInt(s);
            dfs(String.valueOf(n/10 + n%10), cnt);
        } else {
            for (int i = 1; i < len; i++) {
                for (int j = i+1; j < len; j++) {
                    int n = Integer.parseInt(s.substring(0, i)) + Integer.parseInt(s.substring(i, j)) + Integer.parseInt(s.substring(j));
                    dfs(String.valueOf(n), cnt);
                }
            }
        }
    }

    static int getOdds(String s, int len) {
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int c = s.charAt(i) - '0';
            if (c % 2 != 0) cnt ++;
        }
        return cnt;
    }
}

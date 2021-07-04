package String.P9252;

import java.io.*;

public class Main {

    static String s1, s2;
    static int n1, n2;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P9252/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s1 = br.readLine();
        s2 = br.readLine();
        n1 = s1.length();
        n2 = s2.length();

        dp = new int[n1+1][n2+1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = n1, j = n2;
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.insert(0, s1.charAt(i-1));
                i--;
                j--;
            } else {
                if (dp[i][j-1] > dp[i-1][j]) j--;
                else i--;
            }
        }

        System.out.println(dp[n1][n2]);
        System.out.println(sb);
    }
}

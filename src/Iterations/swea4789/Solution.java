package Iterations.swea4789;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

    static int T;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Iterations/swea4789/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            int cnt = 0, need = 0;
            for (int i = 0, size = s.length(); i < size; i++) {
                int n = s.charAt(i) - '0';
                if (n == 0) continue;
                if (cnt >= i) cnt += n;
                else {
                    need += i - cnt;
                    cnt += i - cnt + n;
                }
            }
            sb.append("#").append(t).append(" ").append(need).append("\n");
        }

        System.out.println(sb.toString());
    }
}

package Math.swea8382;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

    static int T, x1, y1, x2, y2, ans;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/swea8382/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] s = br.readLine().split(" ");
            x1 = Integer.parseInt(s[0]);
            y1 = Integer.parseInt(s[1]);
            x2 = Integer.parseInt(s[2]);
            y2 = Integer.parseInt(s[3]);
            int x = Math.abs(x1-x2), y = Math.abs(y1-y2);
            int sub = Math.abs(x-y);
            ans = Math.min(x, y)*2 + (sub%2 == 0 ? sub*2 : sub*2-1);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }
}

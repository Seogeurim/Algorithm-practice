package Tree.swea1233;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    final static int T = 10;
    static int N, flag;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Tree/swea1233/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            flag = 1;
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                char V = st.nextToken().charAt(0);
                if ((V == '+' || V == '-' || V == '*' || V == '/') && !st.hasMoreTokens()) {
                    flag = 0;
                }
            }

            sb.append("#").append(t).append(" ").append(flag).append("\n");
        }

        System.out.println(sb.toString());
    }
}

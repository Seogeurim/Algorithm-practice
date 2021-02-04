package Stack.swea1218;

import java.io.*;
import java.util.*;

public class Solution {

    final static int T = 10;
    static String pre = "([{<", post = ")]}>";
    static Stack<Character> s = new Stack<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Stack/swea1218/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            for (int i = 0; i < n; i++) {
                char cur = input.charAt(i);
                if (pre.indexOf(cur) >= 0) s.push(cur);
                else if (!s.isEmpty() && pre.indexOf(s.peek()) == post.indexOf(cur)) s.pop();
                else break;
            }

            System.out.println("#" + t + " " + (s.isEmpty() ? 1 : 0));
            s.clear();
        }
    }
}

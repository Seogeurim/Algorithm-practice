package Stack.swea1223;

import java.io.*;
import java.util.*;

public class Solution {

    final static int T = 10;
    static int N;
    static String s;
    static Stack<Character> charSt = new Stack<>();
    static Stack<Integer> intSt = new Stack<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Stack/swea1223/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            s = br.readLine();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                char c = s.charAt(i);
                if (c == '+' || c == '*') {
                    if (!charSt.isEmpty() && charSt.peek() <= c) sb.append(charSt.pop());
                    charSt.push(c);
                } else sb.append(c);
            }
            while (!charSt.isEmpty()) sb.append(charSt.pop());

            for (int i = 0; i < N; i++) {
                char c = sb.charAt(i);
                if (c == '+') intSt.push(intSt.pop() + intSt.pop());
                else if (c == '*') intSt.push(intSt.pop() * intSt.pop());
                else intSt.push(c - '0');
            }

            System.out.println("#" + t + " " + intSt.pop());
        }
    }
}

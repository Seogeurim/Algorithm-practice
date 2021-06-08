package Stack.P1918;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String s, ops = "+-*/";
    static Stack<Character> stack;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Stack/P1918/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if ('A' <= c && c <= 'Z') sb.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                char op;
                while ((op = stack.pop()) != '(') sb.append(op);
            } else {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        ops.indexOf(stack.peek()) / 2 >= ops.indexOf(c) / 2) sb.append(stack.pop());
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }
}

package Stack.P1863;

import java.io.*;
import java.util.*;

public class Main {

    static int n, x, y, cnt;
    static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Stack/P1863/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                cnt ++;
            }
            if (y != 0 && (stack.isEmpty() || stack.peek() < y)) stack.push(y);
        }

        System.out.println(cnt + stack.size());
    }
}

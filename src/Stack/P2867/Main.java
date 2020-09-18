package Stack.P2867;

import java.io.*;
import java.util.Stack;

public class Main {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Stack/P2867/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int[] LM = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack.empty() && (nums[stack.peek()] <= nums[i])) stack.pop();
            LM[i] = stack.empty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();
        int[] RM = new int[N];
        for (int i = N-1; i >= 0; i--) {
            while (!stack.empty() && (nums[stack.peek()] < nums[i])) stack.pop();
            RM[i] = stack.empty() ? N-1 : stack.peek() - 1;
            stack.push(i);
        }

        stack.clear();
        int[] lm = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack.empty() && (nums[stack.peek()] >= nums[i])) stack.pop();
            lm[i] = stack.empty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();
        int[] rm = new int[N];
        for (int i = N-1; i >= 0; i--) {
            while (!stack.empty() && (nums[stack.peek()] > nums[i])) stack.pop();
            rm[i] = stack.empty() ? N-1 : stack.peek() - 1;
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += nums[i] * (long)(i- LM[i] + 1) * (long)(RM[i] - i + 1);
            ans -= nums[i] * (long)(i- lm[i] + 1) * (long)(rm[i] - i + 1);
        }

        System.out.println(ans);
    }
}

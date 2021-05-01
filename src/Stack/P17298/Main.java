package Stack.P17298;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr, res;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Stack/P17298/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        res = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            res[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < N; i++) sb.append(res[i]).append(" ");
        System.out.println(sb.toString());
    }
}

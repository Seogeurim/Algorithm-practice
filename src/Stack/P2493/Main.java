package Stack.P2493;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] tops;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Stack/P2493/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tops = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(0 + " ");

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int max = 0;
        for (int i = 1; i < N; i++) {
            if (tops[max] < tops[i]) {
                bw.write(0 + " ");
                max = i;
            } else {
                while (tops[stack.peek()] < tops[i]) {
                    stack.pop();
                }
                bw.write((stack.peek()+1) + " ");
            }
            stack.push(i);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

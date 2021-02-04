package Stack.P2493;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N;
    static int[] tops;
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Stack/P2493/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        tops = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
            while (!s.isEmpty() && tops[s.peek()] < tops[i]) s.pop();
            if (s.isEmpty()) bw.write("0 ");
            else bw.write((s.peek()+1) + " ");
            s.push(i);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
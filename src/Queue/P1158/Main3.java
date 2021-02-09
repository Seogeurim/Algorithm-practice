package Queue.P1158;

import java.io.*;
import java.util.*;

public class Main3 { // using Queue (295780KB / 540ms)

    static int N, K;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Queue/P1158/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) q.offer(i);
        while (!q.isEmpty()) {
            int cnt = K-1;
            while (cnt-- > 0) q.offer(q.poll());
            sb.append(q.poll()).append(", ");
        }

        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb.toString());
    }
}
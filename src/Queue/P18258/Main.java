package Queue.P18258;

import java.io.*;
import java.util.*;

public class Main {

    static int N, rear;
    static Queue<Integer> q;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Queue/P18258/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    rear = Integer.parseInt(st.nextToken());
                    q.offer(rear);
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : rear).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}

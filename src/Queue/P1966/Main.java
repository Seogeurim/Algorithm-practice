package Queue.P1966;

import java.io.*;
import java.util.*;

public class Main {

    static int T, N, M;
    static int[] count;
    static Queue<Node> q;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Queue/P1966/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            count = new int[10];
            q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int pr = Integer.parseInt(st.nextToken());
                q.offer(new Node(i, pr));
                count[pr] ++;
            }

            sb.append(solve()).append("\n");
        }

        System.out.print(sb);
    }

    static int solve() {
        int turn = 1;
        for (int pr = 9; pr >= 1; pr--) {
            while (count[pr]-- > 0) {
                while (!q.isEmpty()) {
                    Node front = q.poll();
                    if (front.pr == pr) {
                        if (front.idx == M) return turn;
                        break;
                    } else {
                        q.offer(front);
                    }
                }
                turn ++;
            }
        }
        return turn;
    }

    static class Node {
        int idx, pr;

        public Node(int idx, int pr) {
            this.idx = idx;
            this.pr = pr;
        }
    }
}

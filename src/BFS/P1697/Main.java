package BFS.P1697;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K;

    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited = new boolean[100001];
    static int time = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P1697/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        q.offer(N);
        loop: while (!q.isEmpty()) {
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                int cur = q.poll();
                visited[cur] = true;
                if (cur == K) break loop;

                if (isValidPath(cur+1) && !visited[cur+1]) q.offer(cur+1);
                if (isValidPath(cur-1) && !visited[cur-1]) q.offer(cur-1);
                if (isValidPath(cur*2) && !visited[cur*2]) q.offer(cur*2);
            }
            time ++;
        }

        System.out.println(time);
    }

    static boolean isValidPath(int p) {
        return 0 <= p && p <= 100000;
    }
}

package Queue.swea1225;

import java.io.*;
import java.util.*;

public class Solution {

    final static int T = 10;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Queue/swea1225/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= T; t++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) q.offer(Integer.parseInt(st.nextToken()));

            int i = 1;
            while (!q.isEmpty()) {
                int n = q.poll();
                if (n-i <= 0) { q.offer(0); break; }
                else q.offer(n-i);
                i = ++i > 5 ? 1 : i;
            }

            System.out.print("#" + t + " ");
            while (!q.isEmpty()) System.out.print(q.poll() + " ");
            System.out.println();
        }
    }
}
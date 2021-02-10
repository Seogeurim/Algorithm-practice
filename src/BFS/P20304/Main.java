package BFS.P20304;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, p;
    static int[] pwds;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/BFS/P20304/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        pwds = new int[N+1];
        Arrays.fill(pwds, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            p = Integer.parseInt(st.nextToken());
            q.offer(p);
            pwds[p] = 0;
        }

        int ans = 0, cnt = 0;
        while (!q.isEmpty()) {
            int curSize = q.size();
            cnt ++;
            while (curSize-- > 0) {
                int cur = q.poll();
                for (int tmp = 1; tmp <= N; tmp <<= 1) {
                    int next = (cur & tmp) > 0 ? cur - tmp : cur + tmp;
                    if (next <= N && pwds[next] == -1) {
                        pwds[next] = cnt;
                        q.offer(next);
                        ans = cnt;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}

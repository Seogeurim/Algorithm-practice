package BFS.P13549;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static Queue<Position> q = new LinkedList<>();
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;
        boolean flag = false;
        q.offer(new Position(N, 0));
        while (!q.isEmpty()) {
            Position cur = q.poll();
            visited[cur.pos] = true;

            if (cur.pos == K) {
                ans = Math.min(ans, cur.time);
                flag = true;
            }

            if (cur.pos - 1 == K) {
                ans = Math.min(ans, cur.time + 1);
                flag = true;
            } else if (!flag && isValidPath(cur.pos - 1) && !visited[cur.pos - 1]) {
                q.offer(new Position(cur.pos - 1, cur.time + 1));
            }

            if (cur.pos + 1 == K) {
                ans = Math.min(ans, cur.time + 1);
                flag = true;
            } else if (!flag && isValidPath(cur.pos + 1) && !visited[cur.pos + 1]) {
                q.offer(new Position(cur.pos + 1, cur.time + 1));
            }

            if (cur.pos * 2 == K) {
                ans = Math.min(ans, cur.time);
                flag = true;
            } else if (!flag && isValidPath(cur.pos * 2) && !visited[cur.pos * 2]) {
                q.offer(new Position(cur.pos * 2, cur.time));
            }
        }

        System.out.println(ans);
    }

    static boolean isValidPath(int pos) {
        return 0 <= pos && pos <= 100000;
    }
}

class Position {
    int pos;
    int time;

    public Position(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Position{" +
                "pos=" + pos +
                ", time=" + time +
                '}';
    }
}
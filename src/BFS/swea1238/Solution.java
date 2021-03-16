package BFS.swea1238;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int L, start, max;
    static boolean[] visited;
    static LinkedList<Integer>[] graph = new LinkedList[101];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/swea1238/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 100; i++) graph[i] = new LinkedList<>();
            while (L > 0) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                L -= 2;
            }

            max = 0;
            Queue<Integer> q = new LinkedList<>();
            visited = new boolean[101];

            q.offer(start);
            visited[start] = true;
            while (!q.isEmpty()) {
                int curSize = q.size();
                int tmp = 0;
                while (curSize-- > 0) {
                    int from = q.poll();
                    for (int to : graph[from]) {
                        if (!visited[to]) {
                            visited[to] = true;
                            q.offer(to);
                            tmp = Math.max(tmp, to);
                            max = tmp;
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}

package Graph.prg49189;

import java.util.*;

class Solution {

    LinkedList<Integer>[] graph;

    public int solution(int n, int[][] edge) {

        graph = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new LinkedList<>();

        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        return bfs(n);
    }

    int bfs(int n) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(1);
        visited[1] = true;

        int curSize = 0;

        while (!q.isEmpty()) {
            curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                int cur = q.poll();
                for (int next : graph[cur]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }

        return curSize;
    }
}

package _2020_카카오_인턴십.P5;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(9, new int[][]{{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}},
                                              new int[][]{{8,5},{6,7},{4,1}}));
        System.out.println(sol.solution(9, new int[][]{{8,1},{0,1},{1,2},{0,7},{4,7},{0,3},{7,5},{3,6}},
                                              new int[][]{{4,1}, {5, 2}}));
        System.out.println(sol.solution(9, new int[][]{{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}},
                                              new int[][]{{4,1},{8,7},{6,5}}));
    }
}

class Solution {

    ArrayList<Integer>[] paths, graph;
    boolean[] visited, finished;
    boolean hasCycle = false;

    public boolean solution(int n, int[][] path, int[][] order) {

        paths = new ArrayList[n];
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            paths[i] = new ArrayList<>();
        }

        for (int[] p : path) {
            paths[p[0]].add(p[1]);
            paths[p[1]].add(p[0]);
        }

        visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int from = q.poll();
            for (int to : paths[from]) {
                if (visited[to]) continue;
                visited[to] = true;
                graph[from].add(to);
                q.offer(to);
            }
        }

        for (int[] o : order) graph[o[0]].add(o[1]);

        visited = new boolean[n];
        finished = new boolean[n];
        dfs(0);
        return !hasCycle;
    }

    void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) dfs(next);
            else if (!finished[next]) {
                hasCycle = true;
                return;
            }
        }
        finished[node] = true;
    }
}

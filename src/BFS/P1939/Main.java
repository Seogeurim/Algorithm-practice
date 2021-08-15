package BFS.P1939;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, A, B, C, maxWeight;
    static LinkedList<Node>[] graph;
    static Queue<Integer> q;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P1939/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new LinkedList<>();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
            maxWeight = Math.max(maxWeight, C);
        }

        st = new StringTokenizer(br.readLine());
        System.out.println(solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    static int solve(int start, int dest) {
        int low = 1, high = maxWeight;
        q = new LinkedList<>();
        visited = new boolean[N+1];

        int max = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            q.add(start);
            visited[start] = true;

            if (isExist(mid, dest)) {
                max = Math.max(max, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            q.clear();
            Arrays.fill(visited, false);
        }

        return max;
    }

    static boolean isExist(int mid, int dest) {
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Node to : graph[cur]) {
                if (to.weight >= mid) {
                    if (cur == dest) {
                        return true;
                    }
                    if (!visited[to.idx]) {
                        visited[to.idx] = true;
                        q.offer(to.idx);
                    }
                }
            }
        }
        return false;
    }

    static class Node {
        int idx, weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "to=" + idx +
                    ", weight=" + weight +
                    '}';
        }
    }
}

package Graph.P2252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static LinkedList<Integer>[] graph;
    static int[] indegree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P2252/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }
        indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            indegree[to] ++;
        }

        Queue<Integer> zeros = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) zeros.offer(i);
        }

        while (!zeros.isEmpty()) {
            int target = zeros.poll();
            System.out.print(target + " ");

            for (int node : graph[target]) {
                indegree[node] --;
                if (indegree[node] == 0) {
                    zeros.offer(node);
                }
            }
        }
        System.out.println("");

        br.close();
    }
}

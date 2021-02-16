package Tree.P1167;

import java.io.*;
import java.util.*;

public class Main {

    static int V, max = Integer.MIN_VALUE, root, dist;
    static ArrayList<Node>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Tree/P1167/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V+1];

        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to, dist;
            tree[from] = new ArrayList<>();
            while ((to = Integer.parseInt(st.nextToken())) != -1) {
                dist = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, dist));
            }
        }

        visited = new boolean[V+1];
        dfs(1, 0);
        visited = new boolean[V+1];
        dfs(root, 0);

        System.out.println(max);
    }

    static void dfs(int cur, int dist) {
        visited[cur] = true;
        for (Node node : tree[cur]) {
            if (!visited[node.to]) {
                dfs(node.to, dist + node.dist);
            }
        }
        if (dist > max) {
            max = dist;
            root = cur;
        }
    }

    static class Node {
        int to, dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}

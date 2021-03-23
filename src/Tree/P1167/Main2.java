package Tree.P1167;

import java.io.*;
import java.util.*;

public class Main2 {

    static int V, root, ans;
    static ArrayList<Node>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Tree/P1167/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to, dist;
            while ((to = Integer.parseInt(st.nextToken())) != -1) {
                dist = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, dist));
            }
        }

        visited = new boolean[V+1];
        dfs(1, 0);
        dfs(root, 0);

        System.out.println(ans);
    }

    static void dfs(int now, int dist) {
        visited[now] = true;
        for (Node next : tree[now]) {
            if (!visited[next.idx]) {
                dfs(next.idx, dist + next.dist);
            }
        }
        visited[now] = false;

        if (ans < dist) {
            ans = dist;
            root = now;
        }
    }

    static class Node {
        int idx, dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}

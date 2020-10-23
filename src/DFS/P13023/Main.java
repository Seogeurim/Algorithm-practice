package DFS.P13023;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static LinkedList<Integer>[] list;
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P13023/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new LinkedList[N];
        for (int i = 0; i < N; i++) list[i] = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (ans == 0) dfs(i, 1);
        }

        System.out.println(ans);
    }

    static void dfs(int cur, int count) {
        if (count == 5) {
            ans = 1;
            return;
        }

        visited[cur] = true;
        for (int to : list[cur]) {
            if (!visited[to]) dfs(to, count + 1);
        }
        visited[cur] = false;
    }
}

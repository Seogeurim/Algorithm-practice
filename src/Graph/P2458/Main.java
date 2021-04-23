package Graph.P2458;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, next_cnt;
    static LinkedList<Integer>[] graph;
    static int[] cnt;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P5643/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N+1];
        cnt = new int[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            visited= new boolean[N+1];
            next_cnt = 0;
            dfs(i);
            cnt[i] += next_cnt;
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == N) ans ++;
        }

        System.out.println(ans);
    }

    static void dfs(int cur) {
        visited[cur] = true;
        next_cnt ++;
        for (int next : graph[cur]) {
            if (!visited[next]) {
                cnt[next] ++;
                dfs(next);
            }
        }
    }
}

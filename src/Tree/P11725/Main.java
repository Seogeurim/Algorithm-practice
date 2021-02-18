package Tree.P11725;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] parents;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Tree/P11725/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        edges = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int e : edges[cur]) {
                if (parents[e] > 0) continue;
                parents[e] = cur;
                q.offer(e);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) sb.append(parents[i]).append("\n");
        System.out.println(sb.toString());
    }
}

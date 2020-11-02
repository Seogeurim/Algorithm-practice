package Graph.P1707;

import java.io.*;
import java.util.*;

public class Main {

    static int K, V, E;
    static LinkedList<Integer>[] graph;

    static int[] colors;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P1707/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new LinkedList[V+1];
            for (int i = 1; i <= V; i++) graph[i] = new LinkedList<Integer>();
            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int e1 = Integer.parseInt(st.nextToken());
                int e2 = Integer.parseInt(st.nextToken());
                graph[e1].add(e2);
                graph[e2].add(e1);
            }
//            System.out.println(Arrays.toString(graph));

            colors = new int[V+1];
            flag = true;
            for (int i = 1; i <= V && flag; i++) {
                if (colors[i] == 0) {
                    dfs(i, 1);
                }
            }

            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static void dfs(int cur, int cur_color) {
        colors[cur] = cur_color;
//        System.out.println(cur + " " + Arrays.toString(colors));
        for (int to : graph[cur]) {
            if (colors[to] == 0) {
                dfs(to, (-1) * cur_color);
            } else if (colors[to] == cur_color) {
                flag = false;
                return;
            }
        }
    }
}

package Graph.P21276;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static String[] names;
    static HashMap<String, Integer> idx = new HashMap<>();

    static LinkedList<Integer>[] children, graph;
    static int[] indegree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P21276/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        names = new String[N];
        children = new LinkedList[N];
        graph = new LinkedList[N];
        indegree = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) names[i] = st.nextToken();

        Arrays.sort(names);
        for (int i = 0; i < N; i++) {
            idx.put(names[i], i);
            children[i] = new LinkedList<>();
            graph[i] = new LinkedList<>();
        }

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int X = idx.get(st.nextToken()), Y = idx.get(st.nextToken());
            graph[Y].add(X);
            indegree[X] ++;
        }

        Queue<Integer> q = new LinkedList<>();
        LinkedList<Integer> root = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                root.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                indegree[next] --;
                if (indegree[next] == 0) {
                    children[cur].add(next);
                    q.offer(next);
                }
            }
        }

        System.out.println(root.size());
        for (Integer s : root) System.out.print(names[s] + " ");
        System.out.println();

        for (int i = 0; i < N; i++) {
            System.out.print(names[i] + " " + children[i].size() + " ");
            Collections.sort(children[i]);
            for (Integer c : children[i]) System.out.print(names[c] + " ");
            System.out.println();
        }
    }
}

package Graph.P1944;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;

    static int[] di = {-1, 0, 1, 0}, dj = {0, 1, 0, -1};
    static ArrayList<Integer> nodes = new ArrayList<>();
    static PriorityQueue<Path> paths = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
    static int[] root = new int[2501];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P1944/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        for (int i = 1; i <= 2500; i++) root[i] = i;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S' || map[i][j] == 'K') nodes.add(i*N+j);
            }
        }

        for (Integer node : nodes) bfs(node);

        int ans = 0, cnt = 0;
        while (!paths.isEmpty()) {
            Path p = paths.poll();
            if (find(p.from) == find(p.to)) continue;
            merge(p.from, p.to);
            ans += p.dist;
            cnt++;
        }

        if (cnt == nodes.size()-1) System.out.println(ans);
        else System.out.println(-1);
    }

    static int find(int n) {
        if (root[n] == n) return n;
        return root[n] = find(root[n]);
    }

    static void merge(int a, int b) {
        root[find(a)] = find(b);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(start);
        visited[start/N][start%N] = true;
        int d = 0;
        while (!q.isEmpty()) {
            int curSize = q.size();
            d++;
            while (curSize-- > 0) {
                int cur = q.poll();

                for (int t = 0; t < 4; t++) {
                    int to_i = cur/N + di[t];
                    int to_j = cur%N + dj[t];

                    if (map[to_i][to_j] == '1' || visited[to_i][to_j]) continue;

                    visited[to_i][to_j] = true;
                    if (map[to_i][to_j] == 'S' || map[to_i][to_j] == 'K') {
                        paths.offer(new Path(start, to_i*N+to_j, d));
                    } else {
                        q.offer(to_i*N+to_j);
                    }
                }
            }
        }
    }

    static class Path {
        int from, to, dist;

        public Path(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
}
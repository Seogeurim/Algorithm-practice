package Graph.P17472;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] di = {-1, 0, 1, 0}, dj = {0, 1, 0, -1};
    static int[] root;
    static PriorityQueue<Edge> pq = new PriorityQueue<>(((o1, o2) -> o1.dist - o2.dist));

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P17472/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int iNum = 2;
        ArrayList<Node> islands = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) island_bfs(i, j, iNum++);
                if (map[i][j] > 0) islands.add(new Node(i, j));
            }
        }

        for (Node p : islands) {
            for (int k = 0; k < 4; k++) {
                find_edge(p.i, p.j, k, map[p.i][p.j]);
            }
        }

        root = new int[iNum];
        for (int i = 0; i < iNum; i++) root[i] = i;

        int cnt = iNum-3, ans = 0;
        while (!pq.isEmpty() && cnt > 0) {
            Edge e = pq.poll();
            if (find(e.from) == find(e.to)) continue;
            union(e.from, e.to);
            ans += e.dist;
            cnt --;
        }

        if (cnt > 0) System.out.println(-1);
        else System.out.println(ans);
    }

    static int find(int n) {
        if (root[n] == n) return n;
        return root[n] = find(root[n]);
    }

    static void union(int a, int b) {
        root[find(a)] = find(b);
    }

    static void find_edge(int i, int j, int d, int num) {
        int dist = 0;
        int ni = i + di[d], nj = j + dj[d];
        while (isValidPath(ni, nj) && map[ni][nj] != num) {
            if (map[ni][nj] > 0) {
                if (dist >= 2) pq.offer(new Edge(num, map[ni][nj], dist));
                break;
            }
            ni += di[d];
            nj += dj[d];
            dist ++;
        }
    }

    static void island_bfs(int i, int j, int iNum) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j));
        map[i][j] = iNum;
        while (!q.isEmpty()) {
            Node p = q.poll();
            for (int k = 0; k < 4; k++) {
                int ni = p.i + di[k];
                int nj = p.j + dj[k];

                if (isValidPath(ni, nj) && map[ni][nj] == 1) {
                    map[ni][nj] = iNum;
                    q.offer(new Node(ni, nj));
                }
            }
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static class Edge {
        int from, to, dist;

        public Edge(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
}

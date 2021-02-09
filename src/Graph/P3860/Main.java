package Graph.P3860;

import java.io.*;
import java.util.*;

public class Main {

    final static int INF = Integer.MAX_VALUE;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static int W, H, G, E;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[][] map;
    static int[][] D;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P3860/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while ((W = stoi(st.nextToken())) != 0 && (H = stoi(st.nextToken())) != 0) {
            map = new int[H][W];

            G = stoi(br.readLine());
            for (int i = 0; i < G; i++) {
                st = new StringTokenizer(br.readLine());
                int X = stoi(st.nextToken()), Y = stoi(st.nextToken());
                map[Y][X] = 1;
            }

            E = stoi(br.readLine());
            while (E-- > 0) {
                st = new StringTokenizer(br.readLine());
                int X1 = stoi(st.nextToken()), Y1 = stoi(st.nextToken());
                int X2 = stoi(st.nextToken()), Y2 = stoi(st.nextToken());
                int T = stoi(st.nextToken());
                map[Y1][X1] = 2;
                edges.add(new Edge(Y1, X1, Y2, X2, T));
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] > 0) continue;
                    for (int d = 0; d < 4; d++) {
                        int to_i = i + di[d];
                        int to_j = j + dj[d];
                        if (isValidPath(to_i, to_j) && map[to_i][to_j] != 1) {
                            edges.add(new Edge(i, j, to_i, to_j, 1));
                        }
                    }
                }
            }

            D = new int[H][W];
            for (int i = 0; i < H; i++) Arrays.fill(D[i], INF);
            D[0][0] = 0;

            boolean cycle = false;
            for (int i = 0; i <= H * W - G; i++) {
                for (Edge e : edges) {
                    if (!(e.i == H-1 && e.j == W-1) && D[e.i][e.j] != INF && D[e.to_i][e.to_j] > D[e.i][e.j] + e.time) {
                        if (i == H * W - G) {
                            cycle = true;
                            break;
                        }
                        D[e.to_i][e.to_j] = D[e.i][e.j] + e.time;
                    }
                }
            }

            if (cycle) System.out.println("Never");
            else if (D[H-1][W-1] == INF) System.out.println("Impossible");
            else System.out.println(D[H-1][W-1]);

            edges.clear();
            st = new StringTokenizer(br.readLine());
        }
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < H && 0 <= j && j < W;
    }

    static int stoi(String s) { return Integer.parseInt(s); }

    static void printD() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (D[i][j] == INF) System.out.print("INF ");
                else System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("============");
    }

    static class Edge {
        int i, j, to_i, to_j, time;

        public Edge(int i, int j, int to_i, int to_j, int time) {
            this.i = i;
            this.j = j;
            this.to_i = to_i;
            this.to_j = to_j;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "i=" + i +
                    ", j=" + j +
                    ", to_i=" + to_i +
                    ", to_j=" + to_j +
                    ", time=" + time +
                    '}';
        }
    }
}

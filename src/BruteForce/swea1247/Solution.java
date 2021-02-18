package BruteForce.swea1247;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, min;
    static Position start, end;
    static Position[] people;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BruteForce/swea1247/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = stoi(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = stoi(br.readLine());
            people = new Position[N];
            visited = new boolean[N];
            min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new Position(stoi(st.nextToken()), stoi(st.nextToken()));
            end = new Position(stoi(st.nextToken()), stoi(st.nextToken()));
            for (int i = 0; i < N; i++) {
                people[i] = new Position(stoi(st.nextToken()), stoi(st.nextToken()));
            }

            dfs(start, 0, 0);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(Position cur, int count, int dist) {
        if (dist > min) return;
        if (count == N) {
            min = Math.min(min, dist + end.getDist(cur));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(people[i], count+1, dist + people[i].getDist(cur));
                visited[i] = false;
            }
        }
    }

    static int stoi(String s) { return Integer.parseInt(s); }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDist(Position p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }
}

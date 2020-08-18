package Graph.P1717;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int a, b;
    static int[] root;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P1717/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        root = new int[N+1];
        for (int i = 0; i <= N; i++) {
            root[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else if (command == 1) {
                if (find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        root[bRoot] = aRoot;
    }

    static int find(int a) {
        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}

package Graph.jo1863;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, i, j;
    static int[] root, rank;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/jo1863/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        root = new int[N+1];
        rank = new int[N+1];
        for (int k = 1; k <= N; k++) root[k] = k;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            union(i, j);
        }

        int cnt = 0;
        for (int k = 1; k <= N; k++) {
            if (root[k] == k) cnt ++;
        }
        System.out.println(cnt);
    }

    static int find(int n) {
        if (root[n] == n) return n;
        return root[n] = find(root[n]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;
        if (rank[a] < rank[b]) root[a] = b;
        else {
            root[b] = a;
            if (rank[a] == rank[b]) rank[a] ++;
        }
    }
}

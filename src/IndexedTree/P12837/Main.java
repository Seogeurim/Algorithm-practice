package IndexedTree.P12837;

import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;
    static long[] segTree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/IndexedTree/P12837/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        segTree = new long[(int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1)];
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken()), p2 = Integer.parseInt(st.nextToken());

            if (cmd == 1) query1(1, 1, N, p1, p2);
            else sb.append(query2(1, 1, N, p1, p2)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void query1(int node, int start, int end, int p, int x) {
        if (start <= p && p <= end) {
            if (start == end) segTree[node] += x;
            else {
                query1(node*2, start, (start+end)/2, p, x);
                query1(node*2+1, (start+end)/2+1, end, p, x);
                segTree[node] = segTree[node*2] + segTree[node*2+1];
            }
        }
    }

    static long query2(int node, int start, int end, int p, int q) {
        if (q < start || end < p) return 0;
        if (p <= start && end <= q) return segTree[node];
        return query2(node*2, start, (start+end)/2, p, q)
                + query2(node*2+1, (start+end)/2+1, end, p, q);
    }
}

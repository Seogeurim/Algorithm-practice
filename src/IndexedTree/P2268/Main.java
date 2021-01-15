package IndexedTree.P2268;

import java.io.*;
import java.util.*;

public class Main {

    final static char CMD_SUM = '0', CMD_MOD = '1';
    static int N, M;
    static long[] segmentTree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/IndexedTree/P2268/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        segmentTree = new long[(int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1)];

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            int p1 = Integer.parseInt(st.nextToken()), p2 = Integer.parseInt(st.nextToken());
            if (cmd == CMD_SUM) sb.append(sum(1, 1, N, p1, p2)).append("\n");
            else if (cmd == CMD_MOD) modify(1, 1, N, p1, p2);
        }
        System.out.println(sb.toString());
    }

    static long sum(int idx, int start, int end, int i, int j) {
        if (i > j) {
            return sum(idx, start, end, j, i);
        } else {
            if (j < start || end < i) return 0;
            if (i <= start && end <= j) return segmentTree[idx];
            return sum(idx*2, start, (start+end)/2, i, j)
                    + sum(idx*2+1, (start+end)/2 + 1, end, i, j);
        }
    }

    static void modify(int idx, int start, int end, int i, int k) {
        if (i < start || end < i) return;
        if (start == end) segmentTree[idx] = k;
        else {
            modify(idx*2, start, (start+end)/2, i, k);
            modify(idx*2+1, (start+end)/2 + 1, end, i, k);
            segmentTree[idx] = segmentTree[idx*2] + segmentTree[idx*2+1];
        }
    }
}

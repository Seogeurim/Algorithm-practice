package IndexedTree.P2357;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[][] segTree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/IndexedTree/P2357/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

        segTree = new int[(int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1)][2];
        makeTree(1, 1, N);

        StringBuilder sb = new StringBuilder();
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            sb.append(getMin(1, 1, N, a, b)).append(" ")
                    .append(getMax(1, 1, N, a, b)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void makeTree(int node, int start, int end) {
        if (start == end) {
            segTree[node][0] = arr[start];
            segTree[node][1] = arr[end];
            return;
        }
        makeTree(node*2, start, (start+end)/2);
        makeTree(node*2+1, (start+end)/2+1, end);
        segTree[node][0] = Math.min(segTree[node*2][0], segTree[node*2+1][0]);
        segTree[node][1] = Math.max(segTree[node*2][1], segTree[node*2+1][1]);
    }

    static int getMin(int node, int start, int end, int a, int b) {
        if (b < start || end < a) return Integer.MAX_VALUE;
        if (a <= start && end <= b) return segTree[node][0];
        return Math.min(getMin(node*2, start, (start+end)/2, a, b),
                            getMin(node*2+1,(start+end)/2+1, end, a, b));
    }

    static int getMax(int node, int start, int end, int a, int b) {
        if (b < start || end < a) return Integer.MIN_VALUE;
        if (a <= start && end <= b) return segTree[node][1];
        return Math.max(getMax(node*2, start, (start+end)/2, a, b),
                getMax(node*2+1,(start+end)/2+1, end, a, b));
    }
}

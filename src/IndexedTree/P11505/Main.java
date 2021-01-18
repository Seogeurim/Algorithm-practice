package IndexedTree.P11505;

import java.io.*;
import java.util.*;

public class Main {

    static int N, MK;
    static int[] arr;
    static long[] segTree;
    final static int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/IndexedTree/P11505/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        MK = stoi(st.nextToken()) + stoi(st.nextToken());

        arr = new int[N+1];
        for (int i = 1; i <= N; i++) arr[i] = stoi(br.readLine());

        segTree = new long[(int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1)];
        makeTree(1, 1, N);

        StringBuilder sb = new StringBuilder();
        while (MK-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken()), c = stoi(st.nextToken());
            if (a == 1) update(1, 1, N, b, c);
            else if (a == 2) sb.append(mulValues(1, 1, N, b, c)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void makeTree(int node, int start, int end) {
        if (start == end) {
            segTree[node] = arr[start];
            return;
        }
        makeTree(node*2, start, (start+end)/2);
        makeTree(node*2+1, (start+end)/2+1, end);
        segTree[node] = (segTree[node*2] * segTree[node*2+1]) % MOD;
    }

    static void update(int node, int start, int end, int b, int c) {
        if (start <= b && b <= end) {
            if (start == end) segTree[node] = c;
            else {
                update(node*2, start, (start + end)/2, b, c);
                update(node*2+1, (start + end)/2+1, end, b, c);
                segTree[node] = (segTree[node*2] * segTree[node*2+1]) % MOD;
            }
        }
    }

    static long mulValues(int node, int start, int end, int b, int c) {
        if (c < start || end < b) return 1;
        if (b <= start && end <= c) return segTree[node];
        return (mulValues(node*2, start, (start+end)/2, b, c)
                * mulValues(node*2+1, (start+end)/2+1, end, b, c)) % MOD;
    }

    private static int stoi(String s) { return Integer.parseInt(s); }
}

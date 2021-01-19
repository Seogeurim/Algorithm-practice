package Series.수열과쿼리.P13537;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[][] msTree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Series/수열과쿼리/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        msTree = new int[(int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1)][];
        makeTree(1, 1, N);

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            bw.write(query(1, 1, N, i, j, k) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void makeTree(int node, int start, int end) {
        if (start == end) {
            msTree[node] = new int[]{arr[start]};
            return;
        }
        makeTree(node*2, start, (start+end)/2);
        makeTree(node*2+1, (start+end)/2+1, end);
        msTree[node] = new int[end - start + 1];
        merge(node, node*2, node*2+1);
    }

    static void merge(int node, int left, int right) {
        int i = 0, j = 0, cursor = 0;
        while (i < msTree[left].length && j < msTree[right].length) {
            if (msTree[left][i] < msTree[right][j]) msTree[node][cursor++] = msTree[left][i++];
            else msTree[node][cursor++] = msTree[right][j++];
        }
        while (i < msTree[left].length) {
            msTree[node][cursor++] = msTree[left][i++];
        }
        while (j < msTree[right].length) {
            msTree[node][cursor++] = msTree[right][j++];
        }
    }

    static int query(int node, int start, int end, int i, int j, int k) {
        if (j < start || end < i) return 0;
        if (i <= start && end <= j) return findBigger(msTree[node], k);
        return query(node*2, start, (start+end)/2, i, j, k)
                + query(node*2+1, (start+end)/2+1, end, i, j, k);
    }

    static int findBigger(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > k) return arr.length - i;
        }
        return 0;
    }
}

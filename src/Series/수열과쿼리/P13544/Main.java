package Series.수열과쿼리.P13544;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static int[][] mst;
    static int last_ans = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Series/수열과쿼리/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = stoi(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = stoi(st.nextToken());

        mst = new int[(int) Math.pow(2, Math.ceil(Math.log(N)/Math.log(2)) + 1)][];
        init(1, 1, N);

        M = stoi(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken()), b = stoi(st.nextToken()), c = stoi(st.nextToken());
            last_ans = query(1, 1, N, a^last_ans, b^last_ans, c^last_ans);
            bw.write(last_ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void init(int node, int start, int end) {
        if (start == end) {
            mst[node] = new int[]{arr[start-1]};
            return;
        }
        init(node*2, start, (start+end)/2);
        init(node*2+1, (start+end)/2+1, end);
        mst[node] = new int[end - start + 1];
        merge(node, node*2, mst[node*2].length, node*2+1, mst[node*2+1].length);
    }

    static void merge(int node, int left, int lLen, int right, int rLen) {
        int i = 0, j = 0, cursor = 0;
        while (i < lLen && j < rLen) {
            if (mst[left][i] < mst[right][j]) mst[node][cursor++] = mst[left][i++];
            else mst[node][cursor++] = mst[right][j++];
        }
        while (i < lLen) mst[node][cursor++] = mst[left][i++];
        while (j < rLen) mst[node][cursor++] = mst[right][j++];
    }

    static int query(int node, int start, int end, int i, int j, int k) {
        if (j < start || end < i) return 0;
        if (i <= start && end <= j) return mst[node].length - upper_bound(node, k);
        return query(node*2, start, (start+end)/2, i, j, k)
                + query(node*2+1, (start+end)/2+1, end, i, j, k);
    }

    static int upper_bound(int node, int k) {
        int left = 0, right = mst[node].length -1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (mst[node][mid] > k) right = mid;
            else left = mid + 1;
        }
        if (mst[node][right] > k) return right;
        else return mst[node].length;
    }

    static int stoi(String s) { return Integer.parseInt(s); }
}

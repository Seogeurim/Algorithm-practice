package IndexedTree.P1275;

import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/IndexedTree/P1275/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        Q = stoi(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = stoi(st.nextToken());

        SegmentTree tree = new SegmentTree(N, nums);

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken()), y = stoi(st.nextToken());
            int a = stoi(st.nextToken()), b = stoi(st.nextToken());
            System.out.println(tree.sum(1, 1, N, x, y));
            tree.update(1, 1, N, a, b);
        }
    }

    private static int stoi(String s) { return Integer.parseInt(s); }
}

class SegmentTree {
    long[] tree;
    int[] arr;

    public SegmentTree(int N, int[] arr) {
        tree = new long[(int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1)];
        this.arr = arr;
        makeTree(1, 1, N);
    }

    private void makeTree(int idx, int start, int end) {
        if (start == end) {
            tree[idx] = arr[start-1];
            return;
        }
        int mid = (start + end) / 2;
        makeTree(idx*2, start, mid);
        makeTree(idx*2+1, mid+1, end);
        tree[idx] = tree[idx*2] + tree[idx*2+1];
    }

    public long sum(int idx, int start, int end, int x, int y) {
        if (x > y) {
            return sum(idx, start, end, y, x);
        } else {
            if (end < x || start > y) return 0;
            if (x <= start && end <= y) return tree[idx];
            int mid = (start + end) / 2;
            return sum(idx*2, start, mid, x, y) + sum(idx*2+1, mid+1, end, x, y);
        }
    }

    public void update(int idx, int start, int end, int a, int b) {
        if (end < a || start > a) return;
        if (start == end) {
            tree[idx] = b;
            return;
        }
        int mid = (start + end) / 2;
        update(idx*2, start, mid, a, b);
        update(idx*2+1, mid+1, end, a, b);
        tree[idx] = tree[idx*2] + tree[idx*2+1];
    }
}
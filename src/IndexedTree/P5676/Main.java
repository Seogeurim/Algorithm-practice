package IndexedTree.P5676;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] nums;
    final static char CH_CMD = 'C', MUL_CMD = 'P';

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/IndexedTree/P5676/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            N = stoi(st.nextToken());
            K = stoi(st.nextToken());

            st = new StringTokenizer(br.readLine());
            nums = new int[N];
            for (int i = 0; i < N; i++) nums[i] = stoi(st.nextToken());

            SegmentTree tree = new SegmentTree(N, nums);

            StringBuilder sb = new StringBuilder();
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int from = stoi(st.nextToken()), to = stoi(st.nextToken());

                if (command == CH_CMD) tree.changeValue(0, 0, N-1, from-1, to);
                else if (command == MUL_CMD) {
                    int result = tree.multiple(0, 0, N-1, from-1, to-1);
                    if (result == 0) sb.append(0);
                    else sb.append(result > 0 ? '+' : '-');
                }
            }
            System.out.println(sb.toString());
        }

        br.close();
    }

    static int stoi(String s) { return Integer.parseInt(s); }
}

class SegmentTree {
    int[] tree;
    int[] arr;

    public SegmentTree(int N, int[] arr) {
        this.tree = new int[(int) Math.pow(2, (Math.ceil(Math.log(N) / Math.log(2)) + 1))];
        this.arr = arr;
        makeTree(0, 0, N-1);
    }

    private int setValue(int value) {
        return Integer.compare(value, 0);
    }

    void makeTree(int idx, int start, int end) {
        if (start == end) {
            tree[idx] = setValue(arr[start]);
            return;
        }
        makeTree(idx*2+1, start, (start+end)/2);
        makeTree(idx*2+2, (start+end)/2+1, end);
        tree[idx] = tree[idx*2+1] * tree[idx*2+2];
    }

    void changeValue(int idx, int start, int end, int target, int value) {
        if (target < start || target > end) return;
        if (start == end) {
            tree[idx] = setValue(value);
            return;
        }
        changeValue(idx*2+1, start, (start+end)/2, target, value);
        changeValue(idx*2+2, (start+end)/2+1, end, target, value);
        tree[idx] = tree[idx*2+1] * tree[idx*2+2];
    }

    int multiple(int idx, int start, int end, int left, int right) {
        if (end < left || start > right) return 1;
        if (left <= start && end <= right) return tree[idx];
        return multiple(idx*2+1, start, (start+end)/2, left, right)
                * multiple(idx*2+2, (start+end)/2+1, end, left, right);
    }
}
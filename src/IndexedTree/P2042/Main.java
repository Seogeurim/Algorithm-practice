package IndexedTree.P2042;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static long[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/IndexedTree/P2042/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N + 1];
        nums[0] = 0;
        for (int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        IndexedTree tree = new IndexedTree(nums);
        tree.makeTree(1, 1, tree.leafSize);
//        System.out.println(tree);

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("1")) {
                int originIndex = Integer.parseInt(st.nextToken());
                long targetValue = Long.parseLong(st.nextToken());
                long diff = targetValue - nums[originIndex];
                tree.update(1, 1, tree.leafSize, originIndex, diff);
                nums[originIndex] = targetValue;
//                System.out.println(tree);
            } else if (command.equals("2")) {
                int qLeft = Integer.parseInt(st.nextToken());
                int qRight = Integer.parseInt(st.nextToken());
                System.out.println(tree.query(1, 1, tree.leafSize, qLeft, qRight));
            }
        }
    }
}

class IndexedTree {
    long[] tree;
    long[] nums;
    int leafSize, depth;

    public IndexedTree(long[] nums){
        this.nums = nums;
        this.depth = 0;
        while (Math.pow(2, depth) < nums.length - 1) {
            this.depth ++;
        }
        this.leafSize = (int) Math.pow(2, depth);
        this.tree = new long[(int) Math.pow(2, depth + 1)];
    }

    public long makeTree(int node, int left, int right){
        if (left == right) {
            if (left <= nums.length - 1) {
                return tree[node] = nums[left];
            } else {
                return tree[node] = 0;
            }
        }
        int mid = (left + right) / 2;
        tree[node] = makeTree(node * 2, left, mid);
        tree[node] += makeTree(node * 2 + 1, mid + 1, right);
        return tree[node];
    }

    public long query(int node, int left, int right, int qLeft, int qRight){
        if (qRight < left || qLeft > right){
            return 0;
        } else if (qLeft <= left && right <= qRight) {
            return tree[node];
        } else {
            int mid = (left + right) / 2;
            return query(node * 2, left, mid, qLeft, qRight)
                    + query(node * 2 + 1,mid + 1, right, qLeft, qRight);
        }
    }

    public void update(int node, int left, int right, int index, long diff){
        if (index < left || right < index) {
            return;
        } else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(node * 2, left, mid, index, diff);
                update(node * 2 + 1, mid + 1, right, index, diff);
            }
        }
    }

    @Override
    public String toString() {
        return "IndexedTree{" +
                "tree=" + Arrays.toString(tree) +
                ", nums=" + Arrays.toString(nums) +
                ", leafSize=" + leafSize +
                ", depth=" + depth +
                '}';
    }
}

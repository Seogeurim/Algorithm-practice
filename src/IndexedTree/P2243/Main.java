package IndexedTree.P2243;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("src/IndexedTree/P2243/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        IndexedTree candies = new IndexedTree();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("1")) {
                // rank 등수의 사탕을 꺼내는 경우
                int rank = Integer.parseInt(st.nextToken());
                candies.pop(1, 1, candies.leafSize, rank);
            } else if (command.equals("2")) {
                // 사탕 update, input 2개 더
                int grade = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                candies.update(1, 1, candies.leafSize, grade, count);
            }
//            System.out.println(candies);
        }
    }
}

class IndexedTree {
    int[] tree;
    int leafSize;
    int depth;


    public IndexedTree(){
        this.leafSize = 1000000;
        this.depth = 0;
        while (leafSize > Math.pow(2, depth))
            this.depth++;
        this.tree = new int[(int) Math.pow(2, depth + 1)];
    }

    public void update(int node, int left, int right, int value, int diff){
        if (left <= value && value <= right) {
            tree[node] += diff;
            if (left != right){
                int mid = (left + right) / 2;
                update(node * 2, left, mid, value, diff);
                update(node * 2 + 1, mid + 1, right, value, diff);
            }
        }
    }

    public void pop(int node, int left, int right, int rank){
        tree[node]--;
        if (left == right) {
            System.out.println(left);
        } else {
            int mid = (left + right) / 2;
            if (tree[node * 2] >= rank ){
                pop(node * 2, left, mid, rank);
            } else {
                pop(node * 2 + 1, mid + 1, right, rank - tree[node * 2]);
            }
        }
    }

    @Override
    public String toString() {
        return "IndexedTree{" +
                "tree=" + Arrays.toString(tree) +
                ", treeLength=" + tree.length +
                ", leafSize=" + leafSize +
                ", depth=" + depth +
                '}';
    }
}

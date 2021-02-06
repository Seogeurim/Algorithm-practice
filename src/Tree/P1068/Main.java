package Tree.P1068;

import java.io.*;
import java.util.*;

public class Main {

    static int N, R;
    static Node[] tree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Tree/P1068/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new Node[N];
        for (int i = 0; i < N; i++) tree[i] = new Node();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            tree[i].parent = p;
            if (p != -1) tree[p].children.add(i);
        }

        R = Integer.parseInt(br.readLine());

        if (tree[R].parent == -1) System.out.println(0);
        else {
            for (int i = 0; i < tree[tree[R].parent].children.size(); i++) {
                if (tree[tree[R].parent].children.get(i) == R) {
                    tree[tree[R].parent].children.remove(i);
                    break;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            q.offer(R);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int child : tree[cur].children) {
                    q.offer(child);
                }
                tree[cur] = null;
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                if (tree[i] != null && tree[i].children.size() == 0) ans ++;
            }

            System.out.println(ans);
        }
    }

    static class Node {
        int parent;
        List<Integer> children = new ArrayList<>();

        @Override
        public String toString() {
            return "Node{" +
                    "parent=" + parent +
                    ", children=" + children +
                    '}';
        }
    }
}

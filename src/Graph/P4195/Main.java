package Graph.P4195;

import java.io.*;
import java.util.*;

public class Main {

    static int T, F;
    static int[] root, size;
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/P4195/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            F = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            root = new int[F*2];
            size = new int[F*2];
            for (int i = 0; i < F*2; i++) {
                root[i] = i;
                size[i] = 1;
            }

            int f_cnt = 0;
            for (int f = 0; f < F; f++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken(), f2 = st.nextToken();
                if (!map.containsKey(f1)) map.put(f1, f_cnt++);
                if (!map.containsKey(f2)) map.put(f2, f_cnt++);
                int f1_ = map.get(f1), f2_ = map.get(f2);
                merge(f1_, f2_);
                sb.append(size[find(f1_)]).append("\n");
            }
        }

        System.out.print(sb);
    }

    static int find(int n) {
        if (root[n] == n) return n;
        return root[n] = find(root[n]);
    }

    static void merge(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;
        if (size[a] < size[b]) {
            root[a] = b;
            size[b] += size[a];
        } else {
            root[b] = a;
            size[a] += size[b];
        }
    }
}

package Graph.swea3289;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, n, m;
    static int[] root;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Graph/swea3289/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            root = new int[n+1];
            for (int i = 1; i <= n; i++) root[i] = i;

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (cmd == 0) union(a, b);
                else if (cmd == 1) {
                    if (find(a) == find(b)) sb.append(1);
                    else sb.append(0);
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static int find(int n) {
        if (root[n] == n) return n;
        return root[n] = find(root[n]);
    }

    static void union(int a, int b) {
        root[find(a)] = find(b);
    }
}

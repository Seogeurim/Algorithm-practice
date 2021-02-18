package Tree.P2263;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] in, post;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Tree/P2263/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        in = new int[n];
        post = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st1.nextToken());
            post[i] = Integer.parseInt(st2.nextToken());
        }

        search(0, n-1, 0, n-1);
        System.out.println(sb.toString());
    }

    static void search(int i_s, int i_e, int p_s, int p_e) {
        int root = post[p_e], mid;
        sb.append(root).append(" ");
        if (i_s == i_e) return;
        for (mid = i_s; mid <= i_e; mid++) {
            if (in[mid] == root) break;
        }
        if (i_s <= mid-1) search(i_s, mid-1, p_s, p_s+(mid-i_s)-1);
        if (mid < i_e) search(mid+1, i_e, p_s+(mid-i_s), p_e-1);
    }
}

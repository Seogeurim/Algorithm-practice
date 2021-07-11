package DFS.P1062;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, K, max = 0;
    static int[] words;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P1062/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new int[N];
        int bit = 0;
        for (int i = 0; i < 5; i++) bit |= (1 << "antic".charAt(i)-'a');

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().replaceAll("[antic]", "").toCharArray();
            words[i] = bit;
            for (char c : arr) words[i] |= 1 << (c-'a');
        }

        if (K < 5) System.out.println(0);
        else if (K == 26) System.out.println(N);
        else {
            dfs(bit, 0, 5);
            System.out.println(max);
        }
    }

    static void dfs(int bit, int start, int select) {
        if (select == K) {
            int cnt = 0;
            for (int w : words) cnt += (bit | w) == bit ? 1 : 0;
            max = Math.max(max, cnt);
            return;
        }
        for (int i = start; i < 26; i++) {
            if ((bit & (1<<i)) == 0) dfs(bit | (1<<i), i+1, select+1);
        }
    }
}

package TimeComplexity.P15961;

import java.io.*;
import java.util.*;

public class Main {

    static int N, d, k, c, ans;
    static int[] sushi;
    static int[] select;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/TimeComplexity/P15961/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N+k-1];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
            if (i < k-1) sushi[N+i] = sushi[i];
        }

        select = new int[d+1];
        for (int i = 0; i < k; i++) {
            if (select[sushi[i]]++ == 0) ans ++;
        }
        if (select[c]++ == 0) ans++;

        int cnt = ans;
        for (int i = 1; i < N; i++) {
            if (--select[sushi[i-1]] == 0) cnt--;
            if (select[sushi[i+k-1]]++ == 0) cnt ++;
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}

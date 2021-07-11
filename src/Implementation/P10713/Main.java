package Implementation.P10713;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, A, B, C;
    static int[] P, cnt;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Implementation/P10713/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        P = new int[M];
        cnt = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                int from = Math.min(P[i-1], P[i]);
                int to = Math.max(P[i-1], P[i]);
                cnt[from]++;
                cnt[to]--;
            }
        }

        long cost = 0;
        for (int i = 1, k = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            k += cnt[i];
            long X = (long) k*A;
            long Y = (long) k*B+C;
            cost += Math.min(X, Y);
        }

        System.out.println(cost);
    }
}

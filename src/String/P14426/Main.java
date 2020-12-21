package String.P14426;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P14426/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] S = new String[N];
        for (int i = 0; i < N; i++) S[i] = br.readLine();

        int ans = 0;
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (S[j].startsWith(s)) {
                    ans ++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}

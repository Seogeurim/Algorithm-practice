package String.P14425;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P14425/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();
        while (N-- > 0) hs.add(br.readLine());

        int ans = 0;
        for (int i = 0; i < M; i++)
            if (hs.contains(br.readLine())) ans ++;

        System.out.println(ans);
    }
}

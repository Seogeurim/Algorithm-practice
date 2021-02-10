package Array.P20299;

import java.io.*;
import java.util.*;

public class Main {

    static int N, S, M, x1, x2, x3;

    public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/Array/P20299/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            x3 = Integer.parseInt(st.nextToken());

            if (x1+x2+x3 >= S && x1 >= M && x2 >= M && x3 >= M) {
                cnt ++;
                sb.append(x1).append(" ");
                sb.append(x2).append(" ");
                sb.append(x3).append(" ");
            }
        }

        sb.insert(0, cnt + "\n");
        sb.append("\n");

        System.out.println(sb.toString());
    }
}

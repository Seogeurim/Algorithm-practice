package Queue.P1158;

import java.io.*;
import java.util.*;

public class Main { // using Array (14672KB / 420ms)

    static int N, K;
    static boolean[] die;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Queue/P1158/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        die = new boolean[N+1];
        int i = 1, cnt = 1, check = 0;
        while (check < N) {
            if (i > N) i = 1;
            if (die[i]) {
                i++;
                continue;
            }
            if (cnt == K) {
                die[i] = true;
                sb.append(i).append(", ");
                check ++;
                cnt = 1;
            } else {
                cnt ++;
            }
            i++;
        }

        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb.toString());
    }
}
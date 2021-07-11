package Implementation.P11005;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Implementation/P11005/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int X = N%B;
            if (X < 10) sb.insert(0, X);
            else sb.insert(0, (char)(X-10+'A'));
            N /= B;
        }

        System.out.println(sb);
    }
}

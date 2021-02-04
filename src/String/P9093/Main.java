package String.P9093;

import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static StringBuilder sb = new StringBuilder();
    static StringBuffer buf = new StringBuffer();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P9093/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                buf.setLength(0);
                sb.append(buf.append(st.nextToken()).reverse()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

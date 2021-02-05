package Permutation.P9742;

import java.io.*;
import java.util.*;

public class Main {

    static String line, s;
    static int pos;
    static int[] fact = new int[11];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Permutation/P9742/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        fact[1] = 1;
        for (int i = 2; i <= 10; i++) fact[i] = fact[i-1] * i;

        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            sb.append(line).append(" = ");

            s = st.nextToken();
            pos = Integer.parseInt(st.nextToken());

            if (pos > fact[s.length()]) sb.append("No permutation").append("\n");
            else {
                pos --;
                StringBuffer buf = new StringBuffer(s);
                for (int i = s.length()-1; i > 0; i--) {
                    sb.append(buf.charAt(pos/fact[i]));
                    buf.deleteCharAt(pos/fact[i]);
                    pos %= fact[i];
                }
                sb.append(buf.charAt(0)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

package String.P1786;

import java.io.*;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P1786/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();

        if (T.length() < P.length()) {
            System.out.println(0);
        } else {
            sb = new StringBuilder();
            System.out.println(kmp(T, P));
            System.out.println(sb.toString());
        }
    }

    static int[] makePk(String P) {
        int[] Pk = new int[P.length()];
        int k = 0;
        for (int i = 1; i < P.length(); i++) {
            while (k > 0 && P.charAt(i) != P.charAt(k))
                k = Pk[k - 1];
            if (P.charAt(i) == P.charAt(k))
                Pk[i] = ++k;
        }
        return Pk;
    }

    static int kmp(String T, String P) {
        int[] Pk = makePk(P);
        int p_idx = 0, count = 0;
        for (int i = 0; i < T.length(); i++) {
            while (p_idx > 0 && T.charAt(i) != P.charAt(p_idx))
                p_idx = Pk[p_idx - 1];
            if (T.charAt(i) == P.charAt(p_idx)) {
                if (p_idx == P.length() - 1) {
                    p_idx = Pk[p_idx];
                    count ++;
                    sb.append(i - P.length() + 2).append("\n");
                } else {
                    p_idx ++;
                }
            }
        }
        return count;
    }
}

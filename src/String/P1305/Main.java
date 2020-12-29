package String.P1305;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P1305/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] pattern = makePk(s);
        System.out.println(L - pattern[s.length()-1]);
    }

    private static int[] makePk(String s) {
        int[] Pk = new int[s.length()];
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(i) != s.charAt(k))
                k = Pk[k-1];
            if (s.charAt(i) == s.charAt(k))
                Pk[i] = ++k;
        }
        return Pk;
    }
}

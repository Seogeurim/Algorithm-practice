package String.P1213;

import java.io.*;

public class Main {

    static int[] count = new int[26];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P1213/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'A'] ++;
        }

        System.out.println(getPalindrome());
    }

    static String getPalindrome() {
        StringBuilder sb = new StringBuilder();
        String lastChar = "";

        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'A');
            int iter = count[i] / 2;

            while (iter-- > 0) sb.append(c);
            if (count[i] % 2 == 1) {
                if (!lastChar.equals("")) return "I'm Sorry Hansoo";
                lastChar = String.valueOf(c);
            }
        }

        return String.valueOf(sb) + sb.append(lastChar).reverse();
    }
}

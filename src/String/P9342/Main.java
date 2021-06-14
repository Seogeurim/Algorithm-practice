package String.P9342;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P9342/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            if (isValid(br.readLine())) sb.append("Infected!\n");
            else sb.append("Good\n");
        }

        System.out.print(sb);
    }

    static boolean isValid(String s) {
        int p = 0, n = s.length();
        if (!check(s.charAt(0))) return false;
        else if (s.charAt(0) != 'A') p++;

        while (p < n && s.charAt(p) == 'A') p++;
        if (p == n) return false;

        while (p < n && s.charAt(p) == 'F') p++;
        if (p == n) return false;

        while (p < n && s.charAt(p) == 'C') p++;

        return (p == n) || (p == n - 1 && check(s.charAt(p)));
    }

    static boolean check(char c) {
        return c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F';
    }
}

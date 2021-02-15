package BruteForce.P16637;

import java.io.*;

public class Main {

    static int N, ans = Integer.MIN_VALUE;
    static char[] s;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BruteForce/P16637/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        s = br.readLine().toCharArray();

        search(1, s[0]-'0');
        System.out.println(ans);
    }

    static void search(int i, int res) {
        if (i == N) {
            ans = Math.max(ans, res);
            return;
        }

        search(i+2, calc(res, s[i], s[i+1]-'0'));
        if (i+2 < N) search(i+4, calc(res, s[i], calc(s[i+1]-'0', s[i+2], s[i+3]-'0')));
    }

    static int calc(int res, char op, int n) {
        if (op == '+') return res + n;
        else if (op == '-') return res - n;
        else return res * n;
    }
}

package Implementation.P16719;

import java.io.*;

public class Main {

    static char[] S;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Implementation/P16719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine().toCharArray();
        solve(0, S.length-1, 0);
    }

    static void solve(int start, int end, int offset) {
        if (start > end) return;
        int idx = start;
        for (int i = start; i <= end; i++) {
            if (S[idx] > S[i]) idx = i;
        }
        sb.insert(offset, S[idx]);
        System.out.println(sb.toString());
        solve(idx+1, end, offset+1);
        solve(start, idx-1, offset);
    }
}

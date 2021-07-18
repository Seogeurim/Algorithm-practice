package Implementation.P2877;

import java.io.*;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Implementation/P2877/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        solve(Integer.parseInt(br.readLine()));
        System.out.println(sb);
    }

    static void solve(int k) {
        if (k == 0) return;
        if (k % 2 == 0) {
            sb.insert(0, '7');
            solve(k/2-1);
        } else {
            sb.insert(0, '4');
            solve(k/2);
        }
    }
}

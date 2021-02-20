package DAC.P1074;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, r, c, ans;
    static int[] pow = new int[16];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAC/P1074/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        pow[0] = 1;
        for (int i = 1; i <= N; i++) pow[i] = 2 * pow[i-1];

        for (int i = N; i > 0; i--) {
            int unit = pow[i] * pow[i] / 4;
            if (r >= pow[i]/2) { r -= pow[i]/2; ans += unit*2; }
            if (c >= pow[i]/2) { c -= pow[i]/2; ans += unit; }
        }

        System.out.println(ans);
    }
}

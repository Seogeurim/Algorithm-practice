package Implementation.P16463;

import java.io.*;

public class Main {

    static int N, cnt;
    static int[] mdays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Implementation/P16463/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int y = 2019, m = 1, d = 13, yoil = 6;

        while (true) {
            d = (d + mdays[m]) % mdays[m];
            yoil = (yoil + mdays[m]) % 7;
            if (++m == 13) {
                m = 1; ++y;
                mdays[2] = (y%400 == 0) || (y%100 != 0 && y%4 == 0) ? 29 : 28;
            }
            if (y > N) break;
            if (yoil == 4) cnt++;
        }

        System.out.println(cnt);
    }
}

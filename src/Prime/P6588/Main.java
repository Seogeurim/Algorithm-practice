package Prime.P6588;

import java.io.*;

public class Main {

    static int n;
    static boolean[] nums = new boolean[1000001];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/_XPractice/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        nums[1] = true;
        for (int i = 2; i <= 1000000; i++) {
            for (int j = 2; i*j <= 1000000; j++) {
                nums[i*j] = true;
            }
        }

        n = Integer.parseInt(br.readLine());
        while (n != 0) {
            int a = 0, b = 0;
            for (int i = 3; i <= n; i++) {
                if (!nums[i] && !nums[n-i]) {
                    a = i;
                    b = n-i;
                    break;
                }

            }

            if (a+b == n) bw.write(n + " = " + a + " + " + b);
            else bw.write("Goldbach's conjecture is wrong.");
            bw.newLine();

            n = Integer.parseInt(br.readLine());
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

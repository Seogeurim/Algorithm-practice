package DFS.P9095;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

    static int T;
    static int[] cases = new int[11];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P9095/input.txt"));
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) make(i, 0);

        T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(cases[n]);
        }
    }

    static void make(int select, int sum) {
        if (select == 0) {
            if (sum <= 10) cases[sum] ++;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            make(select - 1,sum + i);
        }
    }
}

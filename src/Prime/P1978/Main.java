package Prime.P1978;

import java.util.Scanner;

public class Main {
    static int N;
    static boolean[] nums = new boolean[1001];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        nums[1] = true;
        for (int i = 2; i <= 1000; i++) {
            for (int j = i+1; j <= 1000; j++) {
                if (j % i == 0) nums[j] = true;
            }
        }

        N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (!nums[num]) count ++;
        }

        System.out.println(count);
    }
}

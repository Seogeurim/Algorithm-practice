package TimeComplexity.P2003;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] nums;
    static int low = 0, high = 0;
    static int hit = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/TimeComplexity/P2003/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.next());
        M = Integer.parseInt(sc.next());

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(sc.next());
        }

        while (low < N && high < N) {
            int sum = 0;
            for (int i = low; i <= high; i++)
                sum += nums[i];
            if (sum == M) {
                hit++;
                high++;
            }
            else if (sum < M)
                high ++;
            else low ++;
        }

        System.out.println(hit);
    }
}

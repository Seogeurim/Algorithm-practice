package BruteForce.P3040;

import java.io.*;

public class Main {

    static int sum = -100;
    static int[] nums = new int[9];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BruteForce/P3040/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (nums[i] + nums[j] == sum) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) System.out.println(nums[k]);
                    }
                    break;
                }
            }
        }
    }
}

package DP.P1932;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P1932/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N * (N + 1) / 2 + 1];

        int count = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (j == i) {
                    nums[count] = nums[count - i - 1] + value;
                } else if (j == 0) {
                    nums[count] = nums[count - i] + value;
                } else {
                    int parent_max = Math.max(nums[count - i - 1], nums[count - i]);
                    nums[count] = parent_max + value;
                }
                count ++;
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(nums[nums.length - i - 1], ans);
        }
        System.out.println(ans);
    }
}
package Permutation.P10972;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Permutation/P10972/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int target = N-1;
        while (target > 0 && (nums[target] < nums[target-1])) target --;

        if (target == 0) {
            System.out.println(-1);
        } else {
            boolean[] visited = new boolean[N+1];
            for (int i = 0; i < target - 1; i++) visited[nums[i]] = true;

            for (int i = nums[target-1] + 1; i <= N; i++) {
                if (!visited[i]) {
                    nums[target-1] = i;
                    visited[i] = true;
                    break;
                }
            }

            int idx = target;
            for (int i = 1; i <= N && idx < N; i++) {
                if (!visited[i]) nums[idx++] = i;
            }

            for (int i = 0; i < N; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }
}

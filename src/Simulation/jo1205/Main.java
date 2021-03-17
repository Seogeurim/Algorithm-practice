package Simulation.jo1205;

import java.io.*;
import java.util.*;

public class Main {

    static int N, joker, ans;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/jo1205/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i] == 0) joker ++;
        }

        Arrays.sort(nums);
        ans = joker;
        for (int i = joker; i < N-1; i++) {
            if (nums[i] == nums[i+1]) continue;
            ans = Math.max(ans, makeStraight(i));
        }

        System.out.println(ans);
    }

    static int makeStraight(int start) {
        int cnt = 1, space, remain = joker;
        for (int i = start; i < N-1; i++) {
            if (nums[i] == nums[i+1]) continue;
            if (nums[i] + 1 == nums[i+1]) cnt++;
            else {
                space = nums[i+1] - nums[i] - 1;
                if (space <= remain) {
                    cnt += space + 1;
                    remain -= space;
                } else break;
            }
        }
        return cnt + remain;
    }
}

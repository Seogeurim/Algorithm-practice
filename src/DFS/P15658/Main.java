package DFS.P15658;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] nums;
    static int[] ops = new int[4];
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];

        for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
        for (int i = 0; i < 4; i++) ops[i] = sc.nextInt();

        dfs(0, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int count, int res) {
        if (count == N - 1) {
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i] --;
                dfs(count + 1, cal(i, res, nums[count + 1]));
                ops[i] ++;
            }
        }
    }

    static int cal(int op, int target, int calnum) {
        if (op == 0) target += calnum;
        else if (op == 1) target -= calnum;
        else if (op == 2) target *= calnum;
        else target /= calnum;

        return target;
    }
}

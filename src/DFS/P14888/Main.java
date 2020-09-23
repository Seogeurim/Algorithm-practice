package DFS.P14888;

import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static int[] ops;

    static boolean[] visited;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];
        ops = new int[N-1];

        for (int i = 0; i < N; i++)
            nums[i] = sc.nextInt();

        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int oper_cnt = sc.nextInt();
            for (int j = 0; j < oper_cnt; j++) {
                ops[idx++] = i;
            }
        }

        visited = new boolean[N-1];
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

        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(count + 1, cal(ops[i], res, nums[count + 1]));
                visited[i] = false;
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

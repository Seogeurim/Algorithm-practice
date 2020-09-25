package Permutation.P10974;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] nums;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        visited = new boolean[N];
        ans = new int[N];

        dfs(0, ans);
    }

    static void dfs(int count, int[] arr) {
        if (count == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[count] = i+1;
                dfs(count + 1, arr);
                visited[i] = false;
            }
        }
    }
}

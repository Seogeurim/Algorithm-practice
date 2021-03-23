package BruteForce.P17471;

import java.io.*;
import java.util.*;

public class Main {

    static int N, ans = -1;
    static int[] nums;
    static ArrayList<Integer>[] graph;
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BruteForce/P17471/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        graph = new ArrayList[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            while (m-- > 0) graph[i].add(Integer.parseInt(st.nextToken()));
        }

        selected = new boolean[N+1];
        for (int i = 1; i <= N/2; i++) {
            dfs(1, 0, i);
        }

        System.out.println(ans);
    }

    static void dfs(int start, int cnt, int n) {
        if (cnt == n) {
            int[] A = new int[n], B = new int[N-n];
            int a_cnt = 0, b_cnt = 0;
            for (int i = 1, j = 0, k = 0; i <= N; i++) {
                if (selected[i]) { A[j++] = i; a_cnt += nums[i]; }
                else { B[k++] = i; b_cnt += nums[i]; }
            }
            if (check(A) && check(B)) {
                int res = Math.abs(a_cnt - b_cnt);
                if (ans == -1) ans = res;
                else ans = Math.min(ans, res);
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[i] = true;
            dfs(i+1, cnt+1, n);
            selected[i] = false;
        }
    }

    static boolean check(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.offer(arr[0]);
        visited[arr[0]] = true;

        while (!q.isEmpty()) {
            int p = q.poll();
            for (int next : graph[p]) {
                boolean check = false;
                for (int a : arr) {
                    if (next == a) {
                        check = true;
                        break;
                    }
                }
                if (check && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        for (int a : arr) {
            if (!visited[a]) return false;
        }
        return true;
    }
}

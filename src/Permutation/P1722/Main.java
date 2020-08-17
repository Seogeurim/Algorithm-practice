package Permutation.P1722;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] factorial = new long[21];

    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Permutation/P1722/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        factorial[0] = 1;
        for (int i = 1; i <= 20 ; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int command = Integer.parseInt(st.nextToken());

        if (command == 1) {
            long k = Long.parseLong(st.nextToken());
            int[] ans = new int[N];
            boolean[] visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                long target = factorial[N - i - 1];
                for (int j = 0; j < N; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    if (k <= target) {
                        ans[i] = j + 1;
                        visited[j] = true;
                        break;
                    } else {
                        k -= target;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println("");
        } else if (command == 2) {
            int[] nums = new int[N];
            boolean[] visited = new boolean[N + 1];
            long ans = 0;

            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = 1; j < nums[i]; j++) {
                    if (!visited[j]) {
                        ans += factorial[N - i - 1];
                    }
                }
                visited[nums[i]] = true;
            }

            System.out.println(ans + 1);
        }
    }
}

package TimeComplexity.P1806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] nums;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/TimeComplexity/P1806/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i] == S) ans = 1;
        }

        if (ans == 0) {
            int low = 0;
            int high = 1;
            while (high < N && low < high) {
                long sum = 0;
                for (int i = low; i <= high; i++) {
                    sum += nums[i];
                }
                if (sum >= S) {
                    if (ans == 0) ans = high - low + 1;
                    else ans = Math.min(ans, high - low + 1);
                    if (ans == 2) break;
                    low ++;
                } else {
                    high ++;
                }
            }
        }

        System.out.println(ans);
    }
}

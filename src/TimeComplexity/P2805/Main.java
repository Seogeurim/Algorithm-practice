package TimeComplexity.P2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/TimeComplexity/P2805/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trees = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }
        
        int start = 0;
        int end = max;
        int mid;
        long sum = 0;
        int result = 0;
        
        while (start <= end) {
            mid = (start + end) / 2;
            sum = calc(mid);

            if (sum == M) {
                result = mid;
                break;
            } else if (sum > M) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);

    }

    static long calc(int value) {
        long result = 0;
        for (int i = 0; i < N; i++) {
            if(trees[i] > value)
                result += trees[i] - value;
        }
        return result;
    }
}

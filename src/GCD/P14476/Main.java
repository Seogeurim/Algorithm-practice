package GCD.P14476;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] nums;
    static int answer = 0, K;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/NumberTheory/gcd/P14476/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] gcdLtoR = new int[N];
        int[] gcdRtoL = new int[N];

        gcdLtoR[0] = nums[0];
        for (int i = 1; i < N; i++) {
            gcdLtoR[i] = gcd(gcdLtoR[i-1], nums[i]);
        }

        gcdRtoL[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            gcdRtoL[i] = gcd(gcdRtoL[i+1], nums[i]);
        }

//        System.out.println(Arrays.toString(gcdLtoR));
//        System.out.println(Arrays.toString(gcdRtoL));

        for (int i = 0; i < N; i++) {
            int gcd = 0;
            if (i - 1 < 0)  {
                gcd = gcdRtoL[i + 1];
            } else if (i + 1 >= N) {
                gcd = gcdLtoR[i - 1];
            } else {
                gcd = gcd(gcdLtoR[i - 1], gcdRtoL[i + 1]);
            }
            if (nums[i] % gcd != 0 && answer < gcd){
                answer = gcd;
                K = nums[i];
            }
        }

        if (answer == 0) System.out.println(-1);
        else System.out.println(answer + " " + K);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

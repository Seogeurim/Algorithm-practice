package Prime.swea4698;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, D, A, B;
    static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Prime/swea4698/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        prime[0] = prime[1] = true;
        for (int i = 2; i <= 10000; i++) {
            for (int j = i; i*j <= 1000000; j++) {
                prime[i*j] = true;
            }
        }

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = A; i <= B; i++) {
                if (!prime[i] && isContains(i)) cnt++;
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean isContains(int n) {
        while (n > 0) {
            if (n % 10 == D) return true;
            n /= 10;
        }
        return false;
    }
}

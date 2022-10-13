package Prime.P1929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static boolean[] primes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        primes = new boolean[N+1];

        for (int i = 2; i <= N; i++) {
            if (primes[i]) continue;
            for (int j = i+i; j <= N; j += i) primes[j] = true;
            if (i >= M) sb.append(i).append('\n');
        }

        System.out.print(sb);
    }
}

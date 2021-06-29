package Prime.P1644;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Prime/P1644/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1) System.out.println(0);
        else {
            makePrimes();
            System.out.println(solve());
        }
    }

    static int solve() {
        int low = 0, high = 0, len = primes.size(), sum = 2, cnt = 0;
        while (low <= high) {
            if (sum >= N) {
                if (sum == N) cnt ++;
                sum -= primes.get(low++);
            } else {
                if (++high >= len) break;
                sum += primes.get(high);
            }
        }
        return cnt;
    }

    static void makePrimes() {
        boolean[] primeCheck = new boolean[N+1];
        for (int i = 2; i <= N; i++) {
            if (!primeCheck[i]) {
                primes.add(i);
                for (int j = 2; i*j <= N; j++) {
                    primeCheck[i*j] = true;
                }
            }
        }
    }
}

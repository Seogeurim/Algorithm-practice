package TimeComplexity.P2748;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static long n;
    static List<Long> fib;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());

        fib = new ArrayList<>();

        System.out.println(findFib(n));
    }

    static Long findFib(long n){
        fib.add((long) 0);
        fib.add((long) 1);
        fib.add((long) 1);
        for (int i = fib.size(); i <= n; i++) {
            fib.add(fib.get(i-1) + fib.get(i-2));
        }
        return fib.get((int) n);
    }
}

package GCD.P2609;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/GCD/P2609/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int gcd = gcd(N, M);
        int lcm = N * M / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}

package GCD.P1735;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

    static int a, b, c, d;
    static int A, B;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/GCD/P1735/input.txt"));
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        A = a * d + c * b;
        B = b * d;

        int gcd = gcd(A, B);
        A /= gcd;
        B /= gcd;

        System.out.println(A + " " + B);
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0) return n1;
        return gcd(n2, n1%n2);
    }
}

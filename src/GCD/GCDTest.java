package GCD;

public class GCDTest {

    public static void main(String[] args) {
        System.out.println("[Get GCD By Euclidean algorithm]");
        System.out.println(gcd(132, 36));
        System.out.println(gcd(36, 132));
    }

    static int gcd(int a, int b) {
        System.out.println("=========================");
        System.out.println("gcd(" + a + ", " + b + ")");
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
            System.out.println("gcd(" + a + ", " + b + ")");
        }
        return a;
    }
}

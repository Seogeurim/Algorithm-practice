package GCD;

public class GCDTest {

    public static void main(String[] args) {
        System.out.println("[Get GCD By Euclidean algorithm]");
        System.out.println(gcd(132, 36));
        System.out.println(gcd(36, 132));

        System.out.println("[Extended Euclidean algorithm]");
        System.out.println(eGcd(9, 5));
    }

    static int gcd(int a, int b) {
//        System.out.println("=========================");
//        System.out.println("gcd(" + a + ", " + b + ")");
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
//            System.out.println("gcd(" + a + ", " + b + ")");
        }
        return a;
    }

    static ExtendedGCDResult eGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while (r1 != 0) {
            long q = r0 / r1;

            temp = r0 - r1 * q;
            r0 = r1;
            r1 = temp;

            temp = s0 - s1 * q;
            s0 = s1;
            s1 = temp;

            temp = t0 - t1 * q;
            t0 = t1;
            t1 = temp;
        }

        return new ExtendedGCDResult(s0, t0, r0);
    }
}

class ExtendedGCDResult {
    long s;
    long t;
    long r;

    public ExtendedGCDResult(long s, long t, long r) {
        this.s = s;
        this.t = t;
        this.r = r;
    }

    @Override
    public String toString() {
        return "{" +
                "s=" + s +
                ", t=" + t +
                ", r=" + r +
                '}';
    }
}

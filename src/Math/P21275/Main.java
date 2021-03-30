package Math.P21275;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long X;
    static int A, B;
    static int[] n1, n2;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Math/P21275/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken(), s2 = st.nextToken();

        n1 = new int[s1.length()];
        n2 = new int[s2.length()];
        int A_min = 0, B_min = 0;

        for (int i = 0, size = s1.length(); i < size; i++) {
            char c = s1.charAt(size-i-1);
            n1[i] = (c >= 'a') ? c - 'a' + 10 : c - '0';
            A_min = Math.max(A_min, n1[i]+1);
        }
        for (int i = 0, size = s2.length(); i < size; i++) {
            char c = s2.charAt(size-i-1);
            n2[i] = (c >= 'a') ? c - 'a' + 10 : c - '0';
            B_min = Math.max(B_min, n2[i]+1);
        }

        int cnt = 0;
        loop:
        for (int a = A_min; a <= 36; a++) {
            long X1 = 0, a_ = 1;
            for (int i = 0, size = s1.length(); i < size; i++) {
                X1 += n1[i] * a_;
                a_ *= a;
            }
            for (int b = B_min; b <= 36; b++) {
                if (a == b) continue;
                long X2 = 0, b_ = 1;
                for (int i = 0, size = s2.length(); i < size; i++) {
                    X2 += n2[i] * b_;
                    b_ *= b;
                }

                if (X1 >= 0 && X1 == X2) {
                    X = X1;
                    A = a;
                    B = b;
                    if (++cnt > 1) break loop;
                }
            }
        }

        if (cnt == 1) System.out.println(X + " " + A + " " + B);
        else if (cnt > 1) System.out.println("Multiple");
        else System.out.println("Impossible");
    }
}

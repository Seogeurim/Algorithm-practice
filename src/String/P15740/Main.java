package String.P15740;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P15740/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        System.out.println(Integer.parseInt(A) + Integer.parseInt(B));

        boolean isAneg = false, isBneg = false;
        if (A.charAt(0) == '-') {
            A = A.substring(1);
            isAneg = true;
        }
        if (B.charAt(0) == '-') {
            B = B.substring(1);
            isBneg = true;
        }

        if (A.length() > B.length()) B = fillZero(B, A.length() - B.length());
        else A = fillZero(A, B.length() - A.length());

        if (!isAneg && !isBneg) System.out.println(addNum(A, B));
        else if (isAneg && isBneg) System.out.println("-" + addNum(A, B));
        else {
            int i = 0;
            for (; i < A.length(); i++) {
                if (A.charAt(i) > B.charAt(i)) {
                    if (isAneg) System.out.println("-" + subNum(A, B));
                    else System.out.println(subNum(A, B));
                    break;
                }
                if (A.charAt(i) < B.charAt(i)) {
                    if (isBneg) System.out.println("-" + subNum(B, A));
                    else System.out.println(subNum(B, A));
                    break;
                }
            }
            if (i == A.length()) System.out.println(0);
        }
    }

    static String fillZero(String s, int len) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < len; i++) sb.insert(0, 0);
        return sb.toString();
    }

    static String addNum(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int add = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0');
            sb.insert(0, (sum + add) % 10);
            add = (sum + add) / 10;
        }
        if (add > 0) sb.insert(0, add);

        return sb.toString();
    }

    static String subNum(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int borrow = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int sub = (a.charAt(i) - '0') - (b.charAt(i) - '0') - borrow;
            borrow = 0;
            if (sub < 0) {
                sub += 10;
                borrow ++;
            }
            sb.insert(0, sub);
        }

        String ans = sb.toString();
        int i = 0;
        for (; i < ans.length(); i++) {
            if (ans.charAt(i) != '0') break;
        }

        return ans.substring(i);
    }
}

package _2020_KAKAO_BLIND_RECRUITMENT.P2;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("(()())()"));
        System.out.println(sol.solution(")("));
        System.out.println(sol.solution("()))((()"));

    }
}

class Solution {

    static String u, v;

    public String solution(String p) {
        return make(p);
    }

    static String make(String p) {
        if (p.equals("")) return p;
        divide(p);

        if (isValid(u)) {
            return u + make(v);
        } else {
            String temp = u.substring(1, u.length() - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == ')') sb.append("(");
                else sb.append(")");
            }
            return "(" + make(v) + ")" + sb.toString();
        }
    }

    static void divide(String w) {
        int left = 0, right = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                left ++;
            } else if (w.charAt(i) == ')') {
                right ++;
            }

            if (left == right) {
                u = w.substring(0, i + 1);
                v = w.substring(i + 1);
                break;
            }
        }
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.empty()) return false;
                stack.pop();
            }
        }
        return true;
    }
}
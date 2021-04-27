package _2020_카카오_인턴십.P2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("100-200*300-500+20")); // 60420
        System.out.println(sol.solution("50*6-3*2")); // 300
    }
}

class Solution {

    char[][] opCases = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '+', '-'},
            {'*', '-', '+'}
    };

    public long solution(String expression) {

        List<Long> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();

        int idx = 0, n = expression.length();
        while (idx < n) {
            StringBuilder num = new StringBuilder();
            while (idx < n && !isOp(expression.charAt(idx))) {
                num.append(expression.charAt(idx++));
            }
            numList.add(Long.parseLong(num.toString()));
            if (idx < n) opList.add(expression.charAt(idx++));
        }

        long ans = 0;
        for (char[] op : opCases) {
            List<Long> nums = new ArrayList<>(numList);
            List<Character> ops = new ArrayList<>(opList);

            for (int i = 0; i < 3; i++) {
                int ofs;
                while ((ofs = ops.indexOf(op[i])) >= 0) {
                    nums.add(ofs, calc(op[i], nums.get(ofs), nums.get(ofs+1)));
                    nums.remove(ofs+1);
                    nums.remove(ofs+1);
                    ops.remove(ofs);
                }
            }

            ans = Math.max(ans, Math.abs(nums.get(0)));
        }

        return ans;
    }

    private boolean isOp(char c) {
        return c == '+' || c == '*' || c == '-';
    }

    private long calc(char op, long a, long b) {
        if (op == '*') return a*b;
        else if (op == '+') return a+b;
        else return a-b;
    }
}

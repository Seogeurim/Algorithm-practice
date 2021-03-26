package DP.prg42895;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(11, 11));
    }
}

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        int ans = -1;

        HashSet<Integer>[] set = new HashSet[9];
        for (int i = 1; i <= 8; i++) set[i] = new HashSet<>();

        set[1].add(N);
        for (int i = 2; i <= 8; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) sb.append(N);
            set[i].add(Integer.parseInt(sb.toString()));

            for (int j = 1; j < i; j++) {
                for (int v1 : set[j]) {
                    for (int v2 : set[i-j]) {
                        set[i].add(v1 + v2);
                        if (v1-v2 > 0) set[i].add(v1 - v2);
                        set[i].add(v1 * v2);
                        if (v2 != 0) set[i].add(v1 / v2);
                    }
                }
            }

            if (set[i].contains(number)) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}

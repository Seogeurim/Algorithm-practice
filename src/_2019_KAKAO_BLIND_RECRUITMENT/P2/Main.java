package _2019_KAKAO_BLIND_RECRUITMENT.P2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(5, new int[]{2, 1, 2, 2, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(sol.solution(4, new int[]{4, 4, 4, 5, 3})));
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] total = new int[N];
        Map<Integer, Double> fail = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            fail.put(i, (double) 0);
        }

        for (int s : stages) {
            for (int i = 1; i <= s && i != N+1; i++)
                total[i-1] ++;
            if (!(s == N+1)) fail.put(s, fail.get(s)+1);
        }

        for (int i = 1; i <= N; i++) {
            if (fail.get(i) != 0) fail.put(i, fail.get(i) / total[i-1]);
        }

        List<Integer> keys = new ArrayList<>(fail.keySet());
        keys.sort((o1, o2) -> (fail.get(o2).compareTo(fail.get(o1))));

        for (int i = 0; i < N; i++) {
            answer[i] = keys.get(i);
        }

        return answer;
    }
}
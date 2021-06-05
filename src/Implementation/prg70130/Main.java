package Implementation.prg70130;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{5,2,3,3,5,3}));
    }
}

class Solution {
    public int solution(int[] a) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int v : a) map.merge(v, 1, Integer::sum);

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        int max = 0;
        for (int s : keyList) {
            int cnt = 0;
            boolean left = false, right = false;
            for (int v : a) {
                if (v == s) {
                    if (left) {
                        cnt++;
                        left = false;
                    } else if (!right) right = true;
                } else {
                    if (right) {
                        cnt++;
                        right = false;
                    } else if (!left) left = true;
                }
            }

            if (cnt == map.get(s)) return Math.max(max, cnt*2);
            else max = Math.max(max, cnt*2);
        }

        return max;
    }
}

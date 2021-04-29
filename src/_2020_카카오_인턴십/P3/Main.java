package _2020_카카오_인턴십.P3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"AA", "AB", "AC", "AA", "AC"})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"XYZ", "XYZ", "XYZ"})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"DIA", "EM", "EM", "RUB", "DIA"}))); // 3, 5
        System.out.println(Arrays.toString(sol.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));
    }
}

class Solution {

    public int[] solution(String[] gems) {

        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        int n = gems.length, size = set.size();
        int ans_low = 0, ans_high = n-1;

        int low = 0, high = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put(gems[low], 1);
        while (low < n && high < n) {
            if (map.size() < size) {
                high ++;
                if (high < n) map.merge(gems[high], 1, Integer::sum);
            } else {
                if (map.size() == size &&
                    ((ans_high - ans_low) > (high - low) || low < ans_low)) {
                    ans_low = low;
                    ans_high = high;
                }
                if (map.get(gems[low]) != null) map.put(gems[low], map.get(gems[low])-1);
                if (map.get(gems[low]) == 0) map.remove(gems[low]);
                low ++;
            }
        }

        return new int[]{ans_low+1, ans_high+1};
    }
}

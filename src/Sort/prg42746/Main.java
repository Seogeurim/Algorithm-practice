package Sort.prg42746;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{6, 10, 2}));
        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(sol.solution(new int[]{121, 12}));
        System.out.println(sol.solution(new int[]{0, 0, 0, 0}));
        System.out.println(sol.solution(new int[]{0, 0, 9, 5}));
    }
}

class Solution {

    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            str[i] = String.valueOf(numbers[i]);
        Arrays.sort(str, ((o1, o2) -> (o2+o1).compareTo(o1+o2)));
        StringBuilder sb = new StringBuilder();
        for (String s : str) sb.append(s);

        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
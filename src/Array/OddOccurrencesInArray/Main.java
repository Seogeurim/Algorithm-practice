package Array.OddOccurrencesInArray;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }
}

class Solution {

    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : A) {
            if (set.contains(a)) set.remove(a);
            else set.add(a);
        }
        return (int) set.toArray()[0];
    }
}

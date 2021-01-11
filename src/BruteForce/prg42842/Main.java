package BruteForce.prg42842;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(10, 2))); // [4, 3]
        System.out.println(Arrays.toString(sol.solution(8, 1))); // [3, 3]
        System.out.println(Arrays.toString(sol.solution(24, 24))); // [8, 6]
    }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        int brownX = brown / 2 - 1, brownY = 3;
        int yellowY = 1;
        while (yellow != yellowY * (brownX - 2)) {
            brownX --;
            brownY ++;
            yellowY ++;
        }
        return new int[]{brownX, brownY};
    }
}
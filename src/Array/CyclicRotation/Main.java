package Array.CyclicRotation;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 4}, 4)));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 4}, 5)));
        System.out.println(Arrays.toString(s.solution(new int[]{0, 0, 0}, 1)));
        System.out.println(Arrays.toString(s.solution(new int[]{}, 5)));
    }
}

class Solution {
    public int[] solution(int[] A, int K) {
        int[] newArr = new int[A.length];
        if (A.length > 0) K %= A.length;
        int cursor = K;
        for (int i = 0; i < A.length; i++) {
            if (i == A.length - K) cursor = 0;
            newArr[cursor++] = A[i];
        }
        return newArr;
    }
}

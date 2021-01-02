package Array.FrogRiverOne;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }
}

class Solution {
    public int solution(int X, int[] A) {
        boolean[] leaves = new boolean[X+1];
        int count = 0;

        for (int i = 0; i < A.length; i ++) {
            if (!leaves[A[i]]) {
                leaves[A[i]] = true;
                count ++;
            }
            if (count == X) return i;
        }

        return -1;
    }
}
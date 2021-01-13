package Array.PermCheck;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{4, 1, 3, 2}));
        System.out.println(sol.solution(new int[]{4, 1, 3}));
    }
}

class Solution {
    public int solution(int[] A) {
        boolean[] check = new boolean[A.length + 1];
        for (int value : A) {
            if (value > A.length) return 0;
            check[value] = true;
        }
        for (int i = 1; i <= A.length; i++) {
            if (!check[i]) return 0;
        }
        return 1;
    }
}
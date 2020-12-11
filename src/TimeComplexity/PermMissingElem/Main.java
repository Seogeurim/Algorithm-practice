package TimeComplexity.PermMissingElem;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{}));
        System.out.println(sol.solution(new int[]{2, 3, 1, 5}));
    }
}

class Solution {
    public int solution(int[] A) {
        boolean[] checked = new boolean[A.length + 2];
        for (int a : A) checked[a] = true;
        for (int i = 1; i < checked.length; i++) {
            if (!checked[i]) return i;
        }
        return A.length + 1;
    }
}

package TimeComplexity.TapeEquilibrium;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 2, 3}));
        System.out.println(sol.solution(new int[]{3, 1, 2, 4, 3}));
    }
}

class Solution {

    static int N;
    static int[] toRight, toLeft;

    public int solution(int[] A) {
        N = A.length;
        toRight = new int[N];
        toLeft = new int[N];

        toRight[0] = A[0];
        toLeft[N-1] = A[N-1];
        for (int i = 1; i < N; i++) {
            toRight[i] = toRight[i-1] + A[i];
            toLeft[N-i-1] = toLeft[N-i] + A[N-i-1];
        }

        int ans = Integer.MAX_VALUE;
        for (int p = 1; p < A.length; p++) {
            ans = Math.min(ans, Math.abs(toRight[p-1] - toLeft[p]));
        }

        return ans;
    }
}

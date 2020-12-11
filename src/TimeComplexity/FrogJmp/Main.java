package TimeComplexity.FrogJmp;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(10, 10, 30));
        System.out.println(sol.solution(10, 85, 30));
    }
}

class Solution {
    public int solution(int X, int Y, int D) {
        Y -= X;
        return (int) Math.ceil((double) Y / (double) D);
    }
}

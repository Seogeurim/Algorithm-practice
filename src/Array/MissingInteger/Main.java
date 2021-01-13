package Array.MissingInteger;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 2, 3}));
    }
}

class Solution {

    static boolean[] check = new boolean[1000001];

    public int solution(int[] A) {
        for (int value : A) {
            if (value > 0) check[value] = true;
        }
        int ans = 1;
        while (check[ans]) ans ++;
        return ans;
    }
}
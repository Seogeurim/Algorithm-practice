package Iterations.BinaryGap;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(1041));
        System.out.println(s.solution(8));
    }
}

class Solution {
    public int solution(int N) {
        char[] binArr = Integer.toBinaryString(N).toCharArray();
        int ans = 0, start = 0;
        for (int i = 1; i < binArr.length; i++) {
            if (binArr[i] == '1') {
                ans = Math.max(ans, i - start - 1);
                start = i;
            }
        }
        return ans;
    }
}
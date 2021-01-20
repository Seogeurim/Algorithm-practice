package Sort.prg42748;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 5, 2, 6, 3, 7, 4},
                                            new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0] - 1, j = commands[c][1] - 1;
            int[] tempArr = new int[j-i+1];
            System.arraycopy(array, i, tempArr, 0, j-i+1);
            Arrays.sort(tempArr);
            answer[c] = tempArr[commands[c][2] - 1];
        }
        return answer;
    }
}

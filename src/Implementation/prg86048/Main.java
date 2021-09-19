package Implementation.prg86048;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 3, 2}, new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3}, new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(sol.solution(new int[]{3, 2, 1}, new int[]{2, 1, 3})));
    }
}

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int N = enter.length;
        List<HashSet<Integer>> pair = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int e : enter) list.add(e);
        for (int i = 0; i < N; i++) pair.add(new HashSet<>());

        for (int l : leave) {
            int idx = list.indexOf(l);
            for (int i = 0; i < idx; i++) {
                for (int j = i+1; j <= idx; j++) {
                    int x = list.get(i)-1, y = list.get(j)-1;
                    pair.get(x).add(y);
                    pair.get(y).add(x);
                }
            }
            list.remove(idx);
        }

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) answer[i] = pair.get(i).size();

        return answer;
    }
}

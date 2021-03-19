package Hash.prg42579;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"classic", "pop", "classic", "classic", "pop", "abc"}, new int[]{500, 600, 150, 800, 2500, 1})));
//        System.out.println(Arrays.toString(sol.solution(new String[]{"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1})));
    }
}

class Solution {

    HashMap<String, Integer> sum = new HashMap<>();
    HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
    int[] ans;

    public int[] solution(String[] genres, int[] plays) {
        for (int i = 0, n = genres.length; i < n; i++) {
            sum.merge(genres[i], plays[i], Integer::sum);
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new PriorityQueue<>(((o1, o2) -> {
                    if (plays[o2] == plays[o1]) return o1 - o2;
                    return plays[o2] - plays[o1];
                })));
            }
            map.get(genres[i]).add(i);
        }

        int cnt = 0;
        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() == 1) cnt ++;
            else cnt += 2;
        }

        ans = new int[cnt];
        int i = 0;
        List<String> keySet = new ArrayList<>(sum.keySet());
        keySet.sort((o1, o2) -> sum.get(o2) - sum.get(o1));
        for (String key : keySet) {
            for (int j = 0; j < 2 && !map.get(key).isEmpty(); j++) {
                ans[i++] = map.get(key).poll();
            }
        }

        return ans;
    }
}

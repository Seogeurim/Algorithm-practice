package _2021_KAKAO_BLIND_RECRUITMENT.P3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));
    }
}

class Solution {

    public int[] solution(String[] info, String[] query) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        int[] ans = new int[query.length];

        for (String value : info) {
            String[] s = value.split(" ");
            for (int i = 0; i < (1<<4); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & 1<<j) != 0) sb.append(s[j]);
                    else sb.append('-');
                }
                map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(Integer.parseInt(s[4]));
            }
        }

        for (ArrayList<Integer> list : map.values()) {
            list.sort(((o1, o2) -> o1-o2));
        }

        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].split(" ");
            String key = q[0] + q[2] + q[4] + q[6];
            if (map.get(key) != null) {
                ArrayList<Integer> list = map.get(key);
                int target = Integer.parseInt(q[7]);
                int low = 0, high = list.size();
                while (low < high) {
                    int mid = (low + high)/2;
                    if (list.get(mid) < target) low = mid+1;
                    else high = mid;
                }
                ans[i] = list.size() - low;
            }
        }

        return ans;
    }
}

package _2019_KAKAO_BLIND_RECRUITMENT.P3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},
        {"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
    }
}

class Solution {
    public int solution(String[][] relation) {
        int cols = relation[0].length;
        int rows = relation.length;

        List<Integer> cand = new ArrayList<>();

        for (int i = 1; i < (1 << cols); i++) {
            Set<String> set = new HashSet<>();

            for (String[] row : relation) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < cols; k++) {
                    if ((i & (1 << k)) > 0)
                        sb.append(row[k]);
                }
                set.add(sb.toString());
            }

            if (set.size() == rows) {
                boolean isExist = false;
                for (Integer c : cand) {
                    if ((c & i) == c) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) cand.add(i);
            }
        }

        return cand.size();
    }
}
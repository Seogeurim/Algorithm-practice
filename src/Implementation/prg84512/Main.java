package Implementation.prg84512;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("I"));
    }
}

class Solution {

    List<String> list;

    public int solution(String word) {
        list = new ArrayList<>();
        dfs(new StringBuilder());
        Collections.sort(list);
        return list.indexOf(word)+1;
    }

    void dfs(StringBuilder sb) {
        if (sb.length() == 5) return;
        for (int i = 0; i < 5; i++) {
            sb.append("AEIOU".charAt(i));
            list.add(sb.toString());
            dfs(sb);
            sb.setLength(sb.length()-1);
        }
    }
}

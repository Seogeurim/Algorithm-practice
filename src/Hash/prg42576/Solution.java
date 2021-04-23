package Hash.prg42576;

import java.util.*;

class Solution {

    HashMap<String, Integer> map = new HashMap<>();

    public String solution(String[] participant, String[] completion) {

        for (String p : participant) {
            map.merge(p, 1, Integer::sum);
        }

        for (String c : completion) {
            if (map.get(c) == 1) map.remove(c);
            else map.put(c, map.get(c)-1);
        }

        String ans = "";
        for (String s : map.keySet()) ans = s;

        return ans;
    }
}

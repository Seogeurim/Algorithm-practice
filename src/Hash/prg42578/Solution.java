package Hash.prg42578;

import java.util.*;

class Solution {

    HashMap<String, Integer> map = new HashMap<>();
    int ans = 1;

    public int solution(String[][] clothes) {

        for (String[] c : clothes) {
            map.merge(c[1], 1, Integer::sum);
        }

        for (int val : map.values()) {
            ans *= val+1;
        }

        return ans-1;
    }
}

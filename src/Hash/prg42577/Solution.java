package Hash.prg42577;

import java.util.*;

class Solution {

    HashSet<String> set = new HashSet<>();

    public boolean solution(String[] phone_book) {

        Collections.addAll(set, phone_book);

        for (String p : phone_book) {
            for (int i = 1; i < p.length(); i++) {
                if (set.contains(p.substring(0, i))) return false;
            }
        }

        return true;
    }
}

package Queue.prg42586;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();
        int[] time = new int[speeds.length];

        for (int i = 0; i < speeds.length; i++) {
            time[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }

        int cur = time[0], cnt = 1;
        for (int i = 1; i < speeds.length; i++) {
            if (cur < time[i]) {
                list.add(cnt);
                cur = time[i];
                cnt = 1;
            } else {
                cnt ++;
            }
        }
        list.add(cnt);

        return listToArr(list);
    }

    private int[] listToArr(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

package _2021_KAKAO_BLIND_RECRUITMENT.P2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }
}

class Solution {

    HashSet<String> set;
    StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>();
    PriorityQueue<String> pq = new PriorityQueue<>();

    public String[] solution(String[] orders, int[] course) {
        for (int c : course) {
            set = new HashSet<>();
            for (String order : orders) {
                char[] tmp = order.toCharArray();
                Arrays.sort(tmp);
                comb(tmp, c, 0, 0);
            }

            int max = 0;
            for (String menu : set) {
                int cnt = 0;
                for (String order : orders) {
                    boolean contain = true;
                    for (int i = 0; i < menu.length(); i++) {
                        char m = menu.charAt(i);
                        if (!order.contains(m+"")) {
                            contain = false;
                            break;
                        }
                    }
                    if (contain) cnt++;
                }
                if (cnt >= 2 && max <= cnt) {
                    if (max < cnt) {
                        max = cnt;
                        list.clear();
                    }
                    list.add(menu);
                }
            }
            pq.addAll(list);
            list.clear();
        }

        String[] ans = new String[pq.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }

    void comb(char[] order, int r, int start, int cnt) {
        if (cnt == r) {
            sb.setLength(r);
            set.add(sb.toString());
            return;
        }

        for (int i = start, size = order.length; i < size; i++) {
            sb.insert(cnt, order[i]);
            comb(order, r, i+1, cnt+1);
        }
    }
}
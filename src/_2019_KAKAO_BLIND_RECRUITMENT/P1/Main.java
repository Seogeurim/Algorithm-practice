package _2019_KAKAO_BLIND_RECRUITMENT.P1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Change uid1234 Prodo", "Leave uid4567"})));
    }
}

class Solution {
    public String[] solution(String[] record) {
        String[] answer;

        Map<String, String> users = new HashMap<>();
        int count = 0;

        for (String r : record) {
            String[] line = r.split(" ");
            if (!line[0].equals("Leave")) users.put(line[1], line[2]);
            if (!line[0].equals("Change")) count++;
        }

        answer = new String[count];
        int idx = 0;
        for (String r : record) {
            String[] line = r.split(" ");
            String command = line[0];
            if (command.equals("Enter")) {
                answer[idx] = users.get(line[1]) + "님이 들어왔습니다.";
                idx ++;
            } else if (command.equals("Leave")) {
                answer[idx] = users.get(line[1]) + "님이 나갔습니다.";
                idx ++;
            }
        }

        return answer;
    }
}
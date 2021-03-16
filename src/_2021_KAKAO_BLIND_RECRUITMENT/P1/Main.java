package _2021_KAKAO_BLIND_RECRUITMENT.P1;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm"));
    }
}

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        String tmp = new_id.toLowerCase();

        for (int i = 0, size = tmp.length(); i < size; i++) {
            char c = tmp.charAt(i);
            if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.')
                sb.append(c);
        }

        tmp = sb.toString();
        sb.setLength(0);
        for (int i = 0, size = tmp.length(); i < size; i++) {
            char c = tmp.charAt(i);
            if (c == '.' && sb.length() > 0 && sb.charAt(sb.length()-1) == '.') continue;
            sb.append(c);
        }

        if (sb.charAt(0) == '.') sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.setLength(sb.length()-1);

        if (sb.length() == 0) sb.append('a');

        if (sb.length() >= 16) sb.setLength(15);
        if (sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.setLength(sb.length()-1);

        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length()-1));
        }

        return sb.toString();
    }
}
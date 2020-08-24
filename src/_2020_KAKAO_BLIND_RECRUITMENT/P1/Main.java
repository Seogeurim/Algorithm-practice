package _2020_KAKAO_BLIND_RECRUITMENT.P1;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(sol.solution("aabbaccc"));
        System.out.println(sol.solution("ababcdcdababcdcd"));
        System.out.println(sol.solution("abcabcdede"));
        System.out.println(sol.solution("abcabcabcabcdededededede"));
        System.out.println(sol.solution("xababcdcdababcdcd"));
    }
}

class Solution {

    static String target, compare;

    public int solution(String s) {
        int answer = s.length();

        for (int cnt = 1; cnt <= s.length() / 2; cnt++) { // cnt 단위로 문자열 자르기
            int case_ = 0;
            target = s.substring(0, cnt);

            int count = 1;
            for (int i = cnt; i < s.length(); i += cnt) {
                compare = (i + cnt <= s.length()) ? s.substring(i, i + cnt) : s.substring(i);

                if (target.equals(compare)) {
                    count ++;
                } else {
                    if (count == 1) case_ += cnt;
                    else case_ += cnt + (int)(Math.log10(count)+1);
                    count = 1;
                    target = compare;
                }
            }
            if (count == 1) case_ += compare.length();
            else case_ += cnt + (int)(Math.log10(count)+1);

            answer = Math.min(answer, case_);
        }

        return answer;
    }
}
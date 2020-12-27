package _2019_KAKAO_BLIND_RECRUITMENT.P6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("blind", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"}));
        // output 0
        System.out.println(sol.solution("Muzi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}));
        // output 1
    }
}

class Solution {

    private static HashMap<String, PageInfo> map;

    public int solution(String word, String[] pages) {
        int idx = 0;
        map = new HashMap<>();
        for (String html : pages) {
            PageInfo page = new PageInfo(idx++, html.toLowerCase());
            page.calBasicScore(word.toLowerCase());
            map.put(page.url, page);
        }

        for (PageInfo page : map.values()) {
            page.calMatchScore();
        }

        ArrayList<PageInfo> list = new ArrayList<>(map.values());
        Collections.sort(list);

        return list.get(0).index;
    }

    static class PageInfo implements Comparable<PageInfo> {
        int index;
        String html;
        String url;
        String[] linkTo;
        int basic = 0;
        double match = 0;

        public PageInfo(int index, String html) {
            this.index = index;
            this.html = html;
            this.findUrl();
            this.linkTo = this.extractLink();
        }

        private void findUrl() {
            int left = 0, mid = 0, right = 0;
            while (mid <= left) {
                left = this.html.indexOf("<meta", left + 1);
                right = this.html.indexOf(">", left);
                mid = this.html.lastIndexOf("https://", right);
            }
            right = this.html.indexOf("\"", mid);
            this.url = this.html.substring(mid, right);
        }

        private String[] extractLink() {
            final String LINK_START_TAG = "<a href=\"";
            StringBuilder sb = new StringBuilder();
            int link_idx = this.html.indexOf(LINK_START_TAG);
            while (link_idx >= 0) {
                String linkAfter = this.html.substring(link_idx + LINK_START_TAG.length());
                sb.append(linkAfter.split("\"")[0]).append(" ");
                link_idx = this.html.indexOf(LINK_START_TAG, link_idx + 1);
            }
            return sb.toString().split(" ");
        }

        public void calBasicScore(String word) {
            int w_idx = 0;
            for (int i = 0; i < this.html.length(); i++) {
                char c = this.html.charAt(i);
                if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                    if (w_idx < word.length() && c == word.charAt(w_idx)) w_idx ++;
                    else w_idx = 0;
                } else {
                    if (w_idx == word.length()) this.basic ++;
                    w_idx = 0;
                }
            }
            if (w_idx == word.length()) this.basic ++;
        }

        public void calMatchScore() {
            this.match += this.basic;
            for (String link : this.linkTo) {
                if (map.containsKey(link))
                    map.get(link).match += (double) this.basic / this.linkTo.length;
            }
        }

        @Override
        public int compareTo(PageInfo target) {
            if (this.match == target.match) {
                return this.index - target.index;
            } else {
                return Double.compare(target.match, this.match);
            }
        }
    }
}
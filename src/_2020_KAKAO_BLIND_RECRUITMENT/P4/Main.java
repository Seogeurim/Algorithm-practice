package _2020_KAKAO_BLIND_RECRUITMENT.P4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(Arrays.toString(sol.solution(words, queries)));
    }
}

class Solution {

    static Trie[] dict = new Trie[10001];

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (String word : words) {
            int len = word.length();
            if (dict[len] == null) dict[len] = new Trie();
            dict[len].insertFront(word);
            dict[len].insertBack(word);
        }

        for (int i = 0; i < queries.length; i++) {
            int len = queries[i].length();
            if (dict[len] == null) answer[i] = 0;
            else if (queries[i].charAt(0) != '?') answer[i] = dict[len].findFront(queries[i]);
            else answer[i] = dict[len].findBack(queries[i]);
        }

        return answer;
    }
}

class Trie {
    Node rootFront = new Node();
    Node rootBack = new Node();

    void insertFront(String word) {
        Node current = rootFront;
        for (int i = 0; i < word.length(); i++) {
            current.count ++;
            char c = word.charAt(i);
            if (!current.hasChild(c)) {
                current.children[c - 'a'] = new Node();
            }
            current = current.getChild(c);
        }
    }

    void insertBack(String word) {
        Node current = rootBack;
        for (int i = word.length() - 1; i >= 0; i--) {
            current.count ++;
            char c = word.charAt(i);
            if (!current.hasChild(c)) {
                current.children[c - 'a'] = new Node();
            }
            current = current.getChild(c);
        }
    }

    int findFront(String query) {
        Node current = rootFront;
        for (int i = 0; i < query.length(); i++) {
            char q = query.charAt(i);
            if (q == '?') break;

            if (current.hasChild(q)) {
                current = current.getChild(q);
            } else {
                return 0;
            }
        }
        return current.count;
    }

    int findBack(String query) {
        Node current = rootBack;
        for (int i = query.length() - 1; i >= 0; i--) {
            char q = query.charAt(i);
            if (q == '?') break;

            if (current.hasChild(q)) {
                current = current.getChild(q);
            } else {
                return 0;
            }
        }
        return current.count;
    }
}

class Node {
    Node[] children = new Node[26];
    int count = 0;

    boolean hasChild(char c) {
        return children[c - 'a'] != null;
    }

    Node getChild(char c) {
        return children[c - 'a'];
    }
}
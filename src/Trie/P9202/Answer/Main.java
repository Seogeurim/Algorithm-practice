package Trie.P9202.Answer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    static int w, b;
    static char[][] boogle;
    static boolean[][] visited;
    static String answer;
    static int sum;
    static int count;
    static StringBuilder sb = new StringBuilder();
    static Trie trie;

    static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int [] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Trie/P9202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        w = Integer.parseInt(br.readLine());

        trie = new Trie();
        for (int i = 0; i < w; i++) {
            trie.insert(br.readLine());
        }
        br.readLine();

        b = Integer.parseInt(br.readLine());
        for (int t = 0; t < b; t++) {
            boogle = new char[4][4];
            visited = new boolean[4][4];
            answer = "";
            sum = 0;
            count = 0;
            sb = new StringBuilder();

            for (int i = 0; i < 4; i++) {
                String line = br.readLine();
                for (int j = 0; j < 4; j++) {
                    boogle[i][j] = line.charAt(j);
                }
            }

            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    if (trie.root.hasChild(boogle[y][x])) {
                        dfs(y, x, 1, trie.root.getChild(boogle[y][x]));
                    }
                }
            }

            System.out.println(sum + " " + answer + " " + count);

            trie.root.clearHit();
            br.readLine();
        }

    }

    static void dfs(int y, int x, int length, TrieNode node) {
        // 1. 체크인
        visited[y][x] = true;
        sb.append(boogle[y][x]);
        // 2. 목적지인가?
        if (node.isEnd && !node.isHit) {
            // 목적지 처리
            node.isHit = true;
            sum += score[length];
            count ++;
            String foundWord = sb.toString();
            if (compare(answer, foundWord) > 0) {
                answer = foundWord;
            }
        }
        // 3. 갈 수 있는 곳을 순회
        for (int i = 0; i < 8; i++) {
            int to_y = y + dy[i];
            int to_x = x + dx[i];
            // 4. 갈 수 있는가?
            if (isValidPath(to_y, to_x)) {
                if (!visited[to_y][to_x] && node.hasChild(boogle[to_y][to_x])) {
                    // 5. 간다
                    dfs(to_y, to_x, length + 1, node.getChild(boogle[to_y][to_x]));
                }
            }
        }
        // 6. 체크아웃
        visited[y][x] = false;
        sb.deleteCharAt(length - 1);
    }

    static boolean isValidPath(int y, int x){
        return 0 <= y && y < 4 && 0 <= x && x < 4;
    }

    static int compare(String arg0, String arg1) {
        // 내림차순으로 하기 위해서 arg1 > arg0 을 써준 것
        int result = Integer.compare(arg1.length(), arg0.length());
        if (result == 0) {
            // 사전순으로 compare 해서 return 해줌 : 그 diff int로 리턴
            return arg0.compareTo(arg1);
        } else {
            return result;
        }
    }
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.hasChild(c)) {
                current.children[c - 'A'] = new TrieNode();
            }
            current = current.getChild(c);
        }
        current.isEnd = true;
    }

    boolean checkWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.hasChild(c)) {
                current = current.getChild(c);
            } else {
                return false;
            }
        }
        return current.isEnd;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
    boolean isHit;

    TrieNode getChild(char c) {
        return children[c - 'A'];
    }

    boolean hasChild(char c) {
        return children[c - 'A'] != null;
    }

    void clearHit() {
        isHit = false;
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                children[i].clearHit();
            }
        }
    }
}
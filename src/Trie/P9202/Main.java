package Trie.P9202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    static int w;
    static Trie words = new Trie();

    static int b;
    static char[][] boogle;
    static boolean[][] visited;

    static int[] di = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dj = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int [] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    static int total, count;
    static String max_word;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Trie/P9202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        w = Integer.parseInt(br.readLine());
        for (int i = 0; i < w; i++) {
            words.insert(br.readLine());
        }
        br.readLine();

        b = Integer.parseInt(br.readLine());
        for (int t = 0; t < b; t++) {

            boogle = new char[4][4];
            visited = new boolean[4][4];

            total = 0;
            max_word = "";
            count = 0;

            for (int i = 0; i < 4; i++) {
                String line = br.readLine();
                for (int j = 0; j < 4; j++) {
                    boogle[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    char c = boogle[i][j];
                    if (words.root.hasChild(c))
                        dfs(i, j, Character.toString(c), words.root.getChild(c));
                }
            }

            System.out.println(total + " " + max_word + " " + count);

            words.root.clearHit();
            br.readLine();
        }
    }
    
    static void dfs(int i, int j, String word, Node node) {
        visited[i][j] = true;

        if (node.isEnd && !node.isHit){
            node.isHit = true;
            total += score[word.length()];
            max_word = compare(max_word, word);
            count ++;
        }

        for (int k = 0; k < 8; k++) {
            int find_i = i + di[k];
            int find_j = j + dj[k];
            if (isValidPath(find_i, find_j)) {
                char c = boogle[find_i][find_j];
                if (!visited[find_i][find_j] && node.hasChild(c)) {
                    dfs(find_i, find_j, word + c, node.getChild(c));
                }
            }
        }
        
        visited[i][j] = false;
    }
    
    static boolean isValidPath(int i, int j) {
        return i >= 0 && i < 4 && j >= 0 && j < 4;
    }

    static String compare(String old_w, String new_w) {
        if (old_w.length() == new_w.length()) {
            return old_w.compareTo(new_w) <= 0 ? old_w : new_w;
        } else {
            return old_w.length() > new_w.length() ? old_w : new_w;
        }
    }
}

class Trie {
    Node root = new Node();

    void insert(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!currentNode.hasChild(c)) {
                currentNode.children[c - 'A'] = new Node();
            }
            currentNode = currentNode.getChild(c);
        }
        currentNode.isEnd = true;
    }
}

class Node {
    Node[] children = new Node[26];
    boolean isEnd = false;
    boolean isHit = false;

    Node getChild(char c) {
        return children[c - 'A'];
    }

    boolean hasChild(char c) {
        return children[c - 'A'] != null;
    }

    void clearHit() {
        isHit = false;
        for (Node child : children) {
            if (child != null) {
                child.clearHit();
            }
        }
    }
}
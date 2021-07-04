package Trie.P5670;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Trie/P5670/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            Trie trie = new Trie();

            for (int i = 0; i < N; i++) trie.insert(br.readLine());
            double result = (double) trie.query() / N;
            sb.append(String.format("%.2f", result)).append("\n");
        }

        System.out.print(sb);
    }
}

class Trie {
    Node root;
    int sum;

    public Trie() {
        this.root = new Node();
        this.sum = 0;
    }

    public void insert(String s) {
        Node cur = root;
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (!cur.hasChild(c)) {
                cur.children[c-'a'] = new Node();
                cur.children_cnt ++;
            }
            cur = cur.children[c-'a'];
        }
        cur.isEnd = true;
    }

    public int query() {
        query(-1, root);
        return sum;
    }

    public void query(int level, Node cur) {
        if (cur.isEnd) {
            sum += ++level;
        } else if (cur.children_cnt > 1) {
            level ++;
        }

        if (cur == root) level = 0;
        for (int i = 0; i < 26; i++) {
            if (cur.children[i] != null) {
                query(level, cur.children[i]);
            }
        }
    }
}

class Node {
    Node[] children;
    boolean isEnd;
    int children_cnt;

    public Node() {
        this.children = new Node[26];
        this.isEnd = false;
        this.children_cnt = 0;
    }

    public boolean hasChild(char c) {
        return children[c-'a'] != null;
    }
}

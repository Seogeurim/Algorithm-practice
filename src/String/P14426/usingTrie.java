package String.P14426;

import java.io.*;
import java.util.*;

public class usingTrie {

    static int N, M;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P14426/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Trie t = new Trie();
        while (N-- > 0) t.insert(br.readLine());

        int ans = 0;
        while (M-- > 0) {
            if (t.search(br.readLine())) ans ++;
        }

        System.out.println(ans);
    }
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.hasChild(c))
                current.children[c - 'a'] = new TrieNode();
            current = current.getChild(c);
        }
    }

    boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.hasChild(c)) current = current.getChild(c);
            else return false;
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];

    boolean hasChild(char c) {
        return children[c - 'a'] != null;
    }

    TrieNode getChild(char c) {
        return children[c - 'a'];
    }
}
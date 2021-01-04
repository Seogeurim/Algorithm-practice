package String.P9250;

import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;
    static Trie trie = new Trie();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P9250/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) trie.insert(br.readLine());

        trie.makeFail();

        Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            if (trie.search(br.readLine())) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

class Trie {
    Node root = new Node();

    void insert(String s) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!current.hasChild(c))
                current.children[c - 'a'] = new Node();
            current = current.getChild(c);
        }
        current.isEnd = true;
    }

    void makeFail() {
        Queue<Node> q = new LinkedList<>();
        root.fail = root;
        q.offer(root);
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (char c = 'a'; c <= 'z'; c++) {
                if (!current.hasChild(c)) continue;

                Node next = current.getChild(c);
                if (current == root) next.fail = root;
                else {
                    Node dest = current.fail;
                    while (dest != root && !dest.hasChild(c))
                        dest = dest.fail;
                    if (dest.hasChild(c)) dest = dest.getChild(c);
                    next.fail = dest;
                }

                q.offer(next);
            }
        }
    }

    boolean search(String s) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (current != root && !current.hasChild(c))
                current = current.fail;
            if (current.hasChild(c)) current = current.getChild(c);
            if (current.fail.isEnd) return true;
            if (current.isEnd) return true;
        }
        return false;
    }

    static class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
        Node fail = null;

        boolean hasChild(char c) {
            return children[c - 'a'] != null;
        }

        Node getChild(char c) {
            return children[c - 'a'];
        }
    }
}
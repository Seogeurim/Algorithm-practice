package String.P5052;

import java.io.*;
import java.util.*;

public class Main {

    static int T, N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P5052/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            Trie t = new Trie();
            while (N-- > 0) t.insert(br.readLine());
            t.query();
        }
    }

    static class Trie {
        Node root = new Node();

        void insert(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - '0';
                if (!cur.hasChild(c)) cur.children[c] = new Node();
                cur = cur.children[c];
            }
            cur.isEnd = true;
        }

        void query() {
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                Node cur =  q.poll();
                for (int i = 0; i < 10; i++) {
                    if (cur.hasChild(i)) {
                        if (cur.isEnd) {
                            System.out.println("NO");
                            return;
                        }
                        q.offer(cur.children[i]);
                    }
                }
            }
            System.out.println("YES");
        }
    }

    static class Node {
        Node[] children = new Node[10];
        boolean isEnd = false;

        boolean hasChild(int i) { return children[i] != null; }
    }
}

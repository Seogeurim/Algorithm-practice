package String.P10256;

import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static String dna, marker;
    static Trie t;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P10256/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            dna = br.readLine();
            marker = br.readLine();

            t = new Trie();
            for (int i = 0; i <= m; i++) {
                for (int j = i+1; j <= m; j++) {
                    String s = marker.substring(0, i) + reverseStr(marker.substring(i, j)) + marker.substring(j);
                    t.insert(s);
                }
            }
            t.makeFail();
            System.out.println(t.query(dna));
        }
    }

    static String reverseStr(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }
}

class Trie {
    Node root = new Node();

    int getIdx(char c) {
        switch (c) {
            case 'A': return 0;
            case 'G': return 1;
            case 'T': return 2;
            case 'C': return 3;
            default: return -1;
        }
    }

    void insert(String s) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = getIdx(s.charAt(i));
            if (!current.hasChild(idx))
                current.children[idx] = new Node();
            current = current.getChild(idx);
        }
        current.isEnd = true;
    }

    void makeFail() {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        root.fail = root;
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i = 0; i < 4; i++) {
                if (current.hasChild(i)) {
                    Node child = current.getChild(i);
                    if (current == root) child.fail = root;
                    else {
                        Node temp = current.fail;
                        while (temp != root && !temp.hasChild(i))
                            temp = temp.fail;
                        if (temp.hasChild(i))
                            temp = temp.getChild(i);
                        child.fail = temp;
                    }
                    q.offer(child);
                }
            }
        }
    }

    int query(String s) {
        int count = 0;
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = getIdx(s.charAt(i));
            while (current != root && !current.hasChild(idx))
                current = current.fail;
            if (current.hasChild(idx)) {
                current = current.getChild(idx);
                if (current.isEnd) {
                    count ++;
                    current = current.fail;
                }
            }
        }
        return count;
    }

    static class Node {
        Node[] children = new Node[4];
        Node fail;
        boolean isEnd = false;

        boolean hasChild(int idx) {
            return children[idx] != null;
        }

        Node getChild(int idx) {
            return children[idx];
        }
    }
}

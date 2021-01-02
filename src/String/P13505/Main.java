package String.P13505;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[] bin_nums;
    static Trie trie = new Trie();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P13505/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        bin_nums = new String[N];
        for (int i = 0; i < N; i++) {
            bin_nums[i] = toBinaryStr(Integer.parseInt(st.nextToken()));
            trie.insert(bin_nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, trie.findMaxXOR(bin_nums[i]));
        }
        System.out.println(max);
    }

    private static String toBinaryStr(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 30; i >= 0; i--)
            sb.append(((1 << i) & num) > 0 ? '1' : '0');
        return sb.toString();
    }
}

class Trie {
    Node root = new Node();

    void insert(String s) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) == '0' ? 0 : 1;
            if (current.next[n] == null)
                current.next[n] = new Node();
            current = current.next[n];
        }
    }

    int findMaxXOR(String s) {
        StringBuilder sb = new StringBuilder();
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) == '0' ? 0 : 1;
            int opposite = n ^ 1;
            if (current.next[opposite] != null) {
                sb.append('1');
                current = current.next[opposite];
            } else {
                sb.append('0');
                current = current.next[n];
            }

        }
        return Integer.parseInt(sb.toString(), 2);
    }

    private static class Node {
        Node[] next = new Node[2];
    }
}
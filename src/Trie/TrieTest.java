package Trie;

public class TrieTest {

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("ABC");
        System.out.println(t.checkWord("ABC"));
        System.out.println(t.checkWord("ABD"));
        System.out.println(t.checkWord("AB"));
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
    TrieNode[] children = new TrieNode[26]; // 알파벳 대문자만
    boolean isEnd;

    TrieNode getChild(char c) {
        return children[c - 'A'];
    }

    boolean hasChild(char c) {
        return children[c - 'A'] != null;
    }
}
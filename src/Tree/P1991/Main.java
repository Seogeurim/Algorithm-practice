package Tree.P1991;

import java.io.*;

public class Main {

    static int N;
    static Node[] tree = new Node[26];

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/Tree/P1991/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            tree[line[0].charAt(0) - 'A'] = new Node(line[1], line[2]);
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }

    static void preorder(int idx) {
        if (idx < 0) return;
        System.out.print(Character.toString((char) (idx + 'A')));
        preorder(tree[idx].left);
        preorder(tree[idx].right);
    }

    static void inorder(int idx) {
        if (idx < 0) return;
        inorder(tree[idx].left);
        System.out.print(Character.toString((char) (idx + 'A')));
        inorder(tree[idx].right);
    }

    static void postorder(int idx) {
        if (idx < 0) return;
        postorder(tree[idx].left);
        postorder(tree[idx].right);
        System.out.print(Character.toString((char) (idx + 'A')));
    }
}

class Node {
    int left;
    int right;

    public Node(String left, String right) {
        this.left = left.charAt(0) - 'A';
        this.right = right.charAt(0) - 'A';
    }
}
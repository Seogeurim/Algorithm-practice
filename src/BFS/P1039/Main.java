package BFS.P1039;

import java.io.*;
import java.util.*;

public class Main {

    static String N;
    static int K;

    static boolean[][] visited = new boolean[1000001][11];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P1039/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.next();
        K = sc.nextInt();

        if (N.length() <= 1) System.out.println(-1);
        else System.out.println(make(N));
    }

    static String make(String s) {
        Queue<String> q = new LinkedList<>();
        q.offer(s);

        int count = 0;
        while (count < K) {
            int curSize = q.size();
            for (int c = 0; c < curSize; c++) {
                String cur = q.poll();
                for (int i = 0; i < cur.length() - 1; i++) {
                    for (int j = i + 1; j < cur.length(); j++) {
                        String result = swap(cur, i, j);
                        if (result.charAt(0) != '0' && !visited[Integer.parseInt(result)][count]) {
                            q.offer(result);
                            visited[Integer.parseInt(result)][count] = true;
                        }
                    }
                }
            }
            if (q.isEmpty()) return "-1";
            count ++;
        }

        return Collections.max(q);
    }

    static String swap(String s, int one, int two) {
        StringBuilder sb = new StringBuilder(s);
        char temp = s.charAt(two);
        sb.replace(two, two+1, String.valueOf(sb.charAt(one)));
        sb.replace(one, one+1, String.valueOf(temp));
        return sb.toString();
    }
}

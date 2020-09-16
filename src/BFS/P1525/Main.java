package BFS.P1525;

import java.io.*;
import java.util.*;

public class Main {

    final static int TARGET = 123456789;
    static int[] move = {-1, 1, -3, 3};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BFS/P1525/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 0) n = 9;
                num = num * 10 + n;
            }
        }

        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);

        int count = 0;
        boolean flag = false;
        loop: while (!q.isEmpty()) {
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                int c = q.poll();
                if (c == TARGET) {
                    flag = true;
                    break loop;
                }

                int hole = findHole(c);
                for (int j = 0; j < 4; j++) {
                    int to = hole + move[j];

                    if ((0 <= to && to < 9) &&
                            !(hole == 2 && to == 3 || hole == 3 && to == 2) &&
                            !(hole == 5 && to == 6 || hole == 6 && to == 5)) {
                        int s = swap(c, hole, to);
                        if (!set.contains(s)) {
                            q.offer(s);
                            set.add(s);
                        }
                    }
                }
            }
            count ++;
        }

        if (flag) System.out.println(count);
        else System.out.println(-1);
    }

    static int findHole(int num) {
        StringBuilder sb = new StringBuilder(num + "");
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '9') return i;
        }
        return 0;
    }

    static int swap(int num, int hole, int to) {
        StringBuilder sb = new StringBuilder(num + "");
        sb.replace(hole, hole+1, String.valueOf(sb.charAt(to)));
        sb.replace(to, to+1, "9");
        return Integer.parseInt(sb.toString());
    }
}
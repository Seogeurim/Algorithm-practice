package Heap.P11286;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Heap/P11286/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else return Math.abs(o1) - Math.abs(o2);
        });

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            else pq.offer(x);
        }
        System.out.print(sb);
    }
}

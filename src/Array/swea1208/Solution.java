package Array.swea1208;

import java.io.*;
import java.util.*;

public class Solution {

    final static int T = 10, N = 100;
    static int dump;
    static int[] boxes;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Array/swea1208/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= T; t++) {
            dump = Integer.parseInt(br.readLine());
            boxes = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) boxes[i] = Integer.parseInt(st.nextToken());

            int[] target;
            while (dump-- > 0) {
                target = flatten();
                if (boxes[target[1]] - boxes[target[0]] <= 1) break;
                else {
                    boxes[target[1]] --;
                    boxes[target[0]] ++;
                }
            }
            target = flatten();

            System.out.println("#" + t + " " + (boxes[target[1]] - boxes[target[0]]));
        }
    }

    static int[] flatten() {
        int min = Integer.MAX_VALUE, min_idx = 0;
        int max = Integer.MIN_VALUE, max_idx = 0;

        for (int i = 0; i < N; i++) {
            if (boxes[i] < min) {
                min = boxes[i];
                min_idx = i;
            }
            if (boxes[i] > max) {
                max = boxes[i];
                max_idx = i;
            }
        }

        return new int[]{min_idx, max_idx};
    }
}

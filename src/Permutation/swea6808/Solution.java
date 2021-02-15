package Permutation.swea6808;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int T;
    static int[] c1 = new int[9], c2 = new int[9];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Permutation/swea6808/s_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] nums = new boolean[19];
            for (int i = 0; i < 9; i++) {
                c1[i] = Integer.parseInt(st.nextToken());
                nums[c1[i]] = true;
            }

            for (int i = 1, j = 0; i <= 18; i++) {
                if (!nums[i]) c2[j++] = i;
            }

            int win = 0, lose = 0;
            do {
                int sc1 = 0, sc2 = 0;
                for (int i = 0; i < 9; i++) {
                    if (c1[i] > c2[i]) sc1 += c1[i] + c2[i];
                    else sc2 += c1[i] + c2[i];
                }
                if (sc1 > sc2) win ++;
                else if (sc1 < sc2) lose ++;
            } while (np());

            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean np() {
        int i = 8;
        while (i > 0 && c2[i-1] > c2[i]) i--;
        if (i == 0) return false;

        int j = 8;
        while (c2[i-1] > c2[j]) j--;
        swap(i-1, j);

        int k = 8;
        while (i < k) swap(i++, k--);
        return true;
    }

    static void swap(int i, int j) {
        int tmp = c2[i];
        c2[i] = c2[j];
        c2[j] = tmp;
    }
}

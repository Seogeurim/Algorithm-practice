package TimeComplexity.swea3307;

import java.io.*;
import java.util.*;

public class Solution {

    static int T, N;
    static int[] L;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/TimeComplexity/swea3307/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            L = new int[N];
            int last = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                if (i == 0) L[0] = n;
                if (L[last] < n) L[++last] = n;
                else {
                    int start = 0, end = last;
                    while (start < end) {
                        int mid = (start + end) / 2;
                        if (L[mid] < n) start = mid+1;
                        else end = mid;
                    }
                    L[end] = n;
                }
            }

            sb.append("#").append(t).append(" ").append(++last).append("\n");
        }

        System.out.println(sb.toString());
    }
}

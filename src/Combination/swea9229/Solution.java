package Combination.swea9229;

import java.io.*;
import java.util.*;

public class Solution {

    static int TC, N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Combination/swea9229/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int ans = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N && i != j; j++) {
                    if (arr[i] + arr[j] > M) continue;
                    ans = Math.max(ans, arr[i] + arr[j]);
                }
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}
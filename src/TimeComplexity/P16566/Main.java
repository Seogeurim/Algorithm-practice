package TimeComplexity.P16566;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/TimeComplexity/P16566/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            int ub = upper_bound(Integer.parseInt(st.nextToken()));
            while (visited[ub]) ub++;
            visited[ub] = true;
            sb.append(arr[ub]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int upper_bound(int k) {
        int start = 0, end = M;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > k) end = mid;
            else start = mid+1;
        }
        return end;
    }
}

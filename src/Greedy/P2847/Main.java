package Greedy.P2847;

import java.io.*;

public class Main {

    static int N, ans = 0;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Greedy/P2847/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = i; j > 0; j--) {
                if (arr[j-1] < arr[j]) break;
                ans += arr[j-1]-(arr[j]-1);
                arr[j-1] = arr[j]-1;
            }
        }

        System.out.println(ans);
    }
}

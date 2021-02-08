package Sort.P2750;

import java.io.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Sort/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        selectionSort();
        for (int n : arr) bw.write(n + "\n");

        bw.flush(); bw.close(); br.close();
    }

    static void selectionSort() {
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}

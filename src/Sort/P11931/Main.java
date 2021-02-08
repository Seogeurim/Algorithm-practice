package Sort.P11931;

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

        mergeSort(0, N-1);
        for (int n : arr) bw.write(n + "\n");

        bw.flush(); bw.close(); br.close();
    }

    static void mergeSort(int start, int end) {
        if (start == end) return;
        mergeSort(start, (start+end)/2);
        mergeSort((start+end)/2+1, end);
        merge(start, (start+end)/2, end);
    }

    static void merge(int start, int mid, int end) {
        int i = start, j = mid+1, k = 0;
        int[] tmp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= end) tmp[k++] = arr[j++];
        for (int t : tmp) arr[start++] = t;
    }
}

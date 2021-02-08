package Sort.P10989;

import java.io.*;

public class Main {

    static int N;
    static int[] arr = new int[10001];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Sort/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) arr[Integer.parseInt(br.readLine())] ++;

        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < arr[i]; j++) {
                bw.write(i + "\n");
            }
        }

        bw.flush(); bw.close(); br.close();
    }
}

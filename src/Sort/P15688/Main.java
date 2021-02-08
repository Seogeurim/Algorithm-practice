package Sort.P15688;

import java.io.*;

public class Main {

    final static int MAX = 1000000;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Sort/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[MAX+1][2];

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num < 0) arr[Math.abs(num)][0] ++;
            else arr[num][1] ++;
        }

        for (int i = MAX; i > 0; i--) {
            for (int j = 0; j < arr[i][0]; j++) {
                sb.append(i * (-1)).append("\n");
            }
        }
        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j < arr[i][1]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}

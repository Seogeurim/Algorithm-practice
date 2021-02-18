package Greedy.jo1828;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] temp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Greedy/jo1828/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        temp = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            temp[i][0] = Integer.parseInt(st.nextToken());
            temp[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(temp, ((o1, o2) -> o1[1]-o2[1]));
        int i = 0, j = 1, cnt = 1;
        while (j < N) {
            if (temp[j][0] > temp[i][1]) {
                cnt ++;
                i = j;
            }
            j++;
        }

        System.out.println(cnt);
    }
}

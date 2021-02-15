package Math.P13458;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, B, C;
    static int[] A;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Math/P13458/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long sum = N;
        for (int i = 0; i < N; i++) sum += A[i] - B > 0 ? Math.ceil((double)(A[i] - B) / C) : 0;
        System.out.println(sum);
    }
}

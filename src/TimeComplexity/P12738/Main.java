package TimeComplexity.P12738;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, last = 0;
    static int[] A, L;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/TimeComplexity/P12738/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        L = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        L[0] = A[0];
        for (int i = 1; i < N; i++) {
            if (L[last] < A[i]) L[++last] = A[i];
            else L[getLowerBound(A[i])] = A[i];
        }

        System.out.println(last+1);
    }

    static int getLowerBound(int k) {
        int low = 0, high = last;
        while (low < high) {
            int mid = (low + high) / 2;
            if (L[mid] < k) low = mid+1;
            else high = mid;
        }

        return low;
    }
}

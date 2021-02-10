package TimeComplexity.P12015;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, L_idx;
    static int[] A, L;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/TimeComplexity/P12015/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        L = new int[N];
        L[0] = A[0];
        for (int i = 1; i < N; i++) {
            if (L[L_idx] < A[i]) L[++L_idx] = A[i];
            else L[getLowerBound(A[i])] = A[i];
        }

        System.out.println(L_idx + 1);
    }

    static int getLowerBound(int k) {
        int low = 0, high = L_idx;
        while (low < high) {
            int mid = (low + high) / 2;
            if (L[mid] < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

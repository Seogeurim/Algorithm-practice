package TimeComplexity.P14003;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, last = 0;
    static int[] A, L, P;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/TimeComplexity/P14003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        L = new int[N];
        P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        L[0] = A[0];
        P[0] = 0;
        for (int i = 0; i < N; i++) {
            if (L[last] < A[i]) {
                L[++last] = A[i];
                P[i] = last;
            } else {
                int low = 0, high = last, k = A[i];
                while (low < high) {
                    int mid = (low+high)/2;
                    if (L[mid] < k) low = mid+1;
                    else high = mid;
                }
                L[low] = k;
                P[i] = low;
            }
        }

        int cnt = last;
        for (int i = N-1; i >= 0; i--) {
            if (P[i] == cnt) {
                sb.insert(0, A[i] + " ");
                cnt--;
            }
            if (cnt == -1) break;
        }

        System.out.println(last+1);
        System.out.println(sb.toString());
    }
}

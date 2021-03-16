package DFS.P1759;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    static int L, C;
    static char[] arr;
    static StringBuilder res = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DFS/P1759/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < C; c++) arr[c] = st.nextToken().charAt(0);

        Arrays.sort(arr);
        comb(0, 0);
    }

    static void comb(int start, int cnt) {
        if (cnt == L) {
            res.setLength(L);
            int v = 0, c = 0;
            for (int i = 0; i < L; i++) {
                if ("aeiou".indexOf(res.charAt(i)) >= 0) v ++;
                else c ++;
            }
            if (v >= 1 && c >= 2) System.out.println(res);
            return;
        }

        for (int i = start; i < C; i++) {
            res.insert(cnt, arr[i]);
            comb(i+1, cnt+1);
        }
    }
}

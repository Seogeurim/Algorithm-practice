package Implementation.P15787;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] train;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Implementation/P15787/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        train = new int[N];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken())-1;
            if (cmd == 1) train[i] |= 1 << Integer.parseInt(st.nextToken());
            else if (cmd == 2) train[i] &= ~(1 << Integer.parseInt(st.nextToken()));
            else if (cmd == 3) {
                train[i] = train[i] << 1;
                train[i] &= ~(1 << 21);
            } else {
                train[i] = train[i] >> 1;
                train[i] &= ~1;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) set.add(train[i]);
        System.out.println(set.size());
    }
}

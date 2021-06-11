package List.P18115;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] card;
    static LinkedList<Integer> list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/List/P18115/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        card = new int[N];
        list = new LinkedList<>();
        for (int i = 0; i < N; i++) list.add(i);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = N; n > 0; n--) {
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) card[list.removeFirst()] = n;
            else if (cmd == 2) card[list.remove(1)] = n;
            else card[list.removeLast()] = n;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(card[i]).append(" ");
        System.out.println(sb);
    }
}

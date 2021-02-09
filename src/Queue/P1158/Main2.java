package Queue.P1158;

import java.io.*;
import java.util.*;

public class Main2 { // using ArrayList (15044KB / 156ms)

    static int N, K;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Queue/P1158/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) list.add(i);
        int target = K-1;
        while (!list.isEmpty()) {
            if (target >= list.size()) target %= list.size();
            sb.append(list.get(target)).append(", ");
            list.remove(target);
            target += K-1;
        }

        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb.toString());
    }
}
package Hash.P1764;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static HashMap<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Hash/P1764/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+M; i++) {
            map.merge(br.readLine(), 1, Integer::sum);
        }

        map.forEach((key, value) -> {
            if (value == 2) list.add(key);
        });

        list.sort(String::compareTo);
        System.out.println(list.size());
        for (String s : list) System.out.println(s);
    }
}

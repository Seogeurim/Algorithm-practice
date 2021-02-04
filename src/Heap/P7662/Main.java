package Heap.P7662;

import java.io.*;
import java.util.*;

public class Main {

    static int T, k;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Heap/P7662/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                if (cmd == 'I') {
                    map.merge(n, 1, Integer::sum);
                } else if (cmd == 'D' && !map.isEmpty()) {
                    int target = (n == 1) ? map.lastKey() : map.firstKey();
                    if (map.get(target) > 1) map.put(target, map.get(target)-1);
                    else map.remove(target);
                }
            }

            if (map.isEmpty()) System.out.println("EMPTY");
            else System.out.println(map.lastKey() + " " + map.firstKey());
        }
    }
}

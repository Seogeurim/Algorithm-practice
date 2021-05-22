package Stack.P2800;

import java.io.*;
import java.util.*;

public class Main {

    static String S;
    static List<int[]> pair;
    static HashSet<String> set;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Stack/P2800/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        pair = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, len = S.length(); i < len; i++) {
            char c = S.charAt(i);
            if (c == '(') stack.push(i);
            else if (c == ')') pair.add(new int[]{stack.pop(), i});
        }

        set = new HashSet<>();
        select(pair.size());

        List<String> result = new ArrayList<>(set);
        result.sort(String::compareTo);
        for (String r : result) System.out.println(r);
    }

    static void select(int n) {
        for (int i = 1; i < 1<<n; i++) {
            StringBuilder sb = new StringBuilder(S);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1<<j)) != 0) {
                    int[] p = pair.get(j);
                    pq.offer(p[0]);
                    pq.offer(p[1]);
                }
            }
            int k = 0;
            while (!pq.isEmpty()) sb.deleteCharAt(pq.poll()-(k++));
            set.add(sb.toString());
        }
    }
}

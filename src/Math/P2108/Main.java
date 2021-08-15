package Math.P2108;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr, cnt;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Math/P2108/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt = new int[8001];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            cnt[arr[i]+4000] ++;
        }
        Arrays.sort(arr);

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        }));
        for (int i = arr[0]+4000; i <= arr[N-1]+4000; i++) {
            if (cnt[i] > 0) pq.offer(new int[]{i-4000, cnt[i]});
        }

        int[] first = pq.poll();
        int mode = pq.size() == 0 || first[1] != pq.peek()[1] ? first[0] : pq.peek()[0];

        System.out.println(Math.round((double) sum / N));
        System.out.println(arr[N/2]);
        System.out.println(mode);
        System.out.println(arr[N-1] - arr[0]);
    }
}

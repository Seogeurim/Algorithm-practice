package String.P6503;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P6503/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m;
        while ((m = Integer.parseInt(br.readLine())) != 0) {
            String s = br.readLine();
            int[] cnt = new int[128];

            int low = 0, high = 0, size = 1, max = 0;
            cnt[s.charAt(0)] = 1;
            while (low <= high) {
                if (size <= m && (high+1) < s.length()) {
                    max = Math.max(max, (high - low + 1));
                    high ++;
                    int h = s.charAt(high);
                    cnt[h] ++;
                    if (cnt[h] == 1) size ++;
                } else {
                    if (size <= m) max = Math.max(max, (high - low + 1));
                    char l = s.charAt(low);
                    cnt[l] --;
                    if (cnt[l] == 0) size --;
                    low ++;
                }
            }
            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }
}

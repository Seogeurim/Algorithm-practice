package Stack.P10799;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Stack/P10799/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int ans = 0, cnt = 0, len = s.length(), i = 0;
        while (i < len) {
            if (s.charAt(i) == '(' && s.charAt(i+1) == ')') {
                ans += cnt;
                i += 2;
            } else {
                if (s.charAt(i) == '(') cnt ++;
                else {
                    ans ++;
                    cnt --;
                }
                i++;
            }
        }

        System.out.println(ans);
    }
}

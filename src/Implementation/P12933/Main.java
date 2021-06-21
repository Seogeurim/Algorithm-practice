package Implementation.P12933;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Implementation/P12933/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(br.readLine()));
    }

    static int solve(String s) {
        int[] quack = new int[5];
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (c == 'q') {
                if (quack[4] > 0) quack[4] --;
                quack[0] ++;
            } else {
                int j = "quack".indexOf(c);
                if (quack[j-1] == 0) return -1;
                quack[j-1] --;
                quack[j] ++;
            }
        }

        if (quack[0] > 0 || quack[1] > 0 || quack[2] > 0 || quack[3] > 0) return -1;
        return quack[4];
    }
}

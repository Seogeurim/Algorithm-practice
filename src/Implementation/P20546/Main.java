package Implementation.P20546;

import java.io.*;
import java.util.*;

public class Main {

    static int j_cash, j_stock, s_cash, s_stock;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Implementation/P20546/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        j_cash = s_cash = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int up = 0, down = 0, last = 0;
        for (int i = 1; i <= 14; i++) {
            int price = Integer.parseInt(st.nextToken());

            j_stock += j_cash / price;
            j_cash -= price * (j_cash / price);

            if (i > 1) {
                if (last < price) {
                    up ++;
                    down = 0;
                } else if (last > price) {
                    down ++;
                    up = 0;
                } else {
                    up = 0;
                    down = 0;
                }
            }

            if (up >= 3) {
                s_cash += price * s_stock;
                s_stock = 0;
            } else if (down >= 3) {
                s_stock += s_cash / price;
                s_cash -= price * (s_cash / price);
            }

            last = price;
        }

        j_cash += last * j_stock;
        s_cash += last * s_stock;

        if (j_cash > s_cash) System.out.println("BNP");
        else if (j_cash < s_cash) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}

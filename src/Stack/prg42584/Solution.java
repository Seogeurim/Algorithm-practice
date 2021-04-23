package Stack.prg42584;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        int N = prices.length;
        int[] res = new int[N];
        Stack<Price> s = new Stack<>();

        for (int i = 0; i < N; i++) {
            int cur = i == N-1 ? 0 : prices[i];
            while (!s.isEmpty() && s.peek().price > cur) {
                Price p = s.pop();
                res[p.time] = i - p.time;
            }
            s.push(new Price(cur, i));
        }

        return res;
    }
}

class Price {
    int price, time;

    public Price(int price, int time) {
        this.price = price;
        this.time = time;
    }
}

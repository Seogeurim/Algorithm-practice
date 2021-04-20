package Simulation.swea9760;

import java.io.*;
import java.util.*;

public class Solution {

    static int T;
    static int[] suit, rank;
    final static String[] cardHand = {
            "",
            "Straight Flush",
            "Four of a Kind",
            "Full House",
            "Flush",
            "Straight",
            "Three of a kind",
            "Two pair",
            "One pair",
            "High card"
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/swea9760/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            suit = new int[4];
            rank = new int[14];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) {
                String s = st.nextToken();
                switch (s.charAt(0)) {
                    case 'S': suit[0] ++; break;
                    case 'D': suit[1] ++; break;
                    case 'H': suit[2] ++; break;
                    case 'C': suit[3] ++; break;
                }
                switch (s.charAt(1)) {
                    case 'A': rank[1] ++; break;
                    case 'T': rank[10] ++; break;
                    case 'J': rank[11] ++; break;
                    case 'Q': rank[12] ++; break;
                    case 'K': rank[13] ++; break;
                    default: rank[s.charAt(1)-'0'] ++; break;
                }
            }

            sb.append("#").append(t).append(" ").append(cardHand[solve()]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int solve() {
        int seq_cnt = 1;
        int[] rank_cnt = new int[6];
        for (int i = 1; i <= 13; i++) {
            if (rank[i-1] == 1 && rank[i] == 1) seq_cnt ++;
            else if (rank[i] == 4) return 2;
            else if (rank[i] >= 2) rank_cnt[rank[i]] ++;
        }
        if (rank[13] == 1 && rank[1] == 1) seq_cnt ++;

        if (rank_cnt[3] == 1) {
            if (rank_cnt[2] == 1) return 3;
            return 6;
        } else if (rank_cnt[2] == 2) return 7;
        else if (rank_cnt[2] == 1) return 8;

        for (int i = 0; i < 4; i++) {
            if (suit[i] == 5) {
                if (seq_cnt == 5) return 1;
                return 4;
            }
        }
        if (seq_cnt == 5) return 5;

        return 9;
    }
}

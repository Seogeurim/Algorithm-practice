package Implementation.prg85002;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{50, 82, 75, 120}, new String[]{"NLWL", "WNLL", "LWNW", "WWLN"})));
    }
}

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int N = weights.length;
        Player[] players = new Player[N];

        for (int i = 0; i < N; i++) {
            players[i] = new Player(i, weights[i]);
            int total = 0, win = 0;
            for (int j = 0; j < N; j++) {
                char c = head2head[i].charAt(j);
                if (c == 'N') continue;
                if (c == 'W') {
                    if (weights[j] > weights[i]) players[i].win_heavy ++;
                    win ++;
                }
                total ++;
            }
            if (total > 0) players[i].win_rate = (double) win / total * 100;
        }

        Arrays.sort(players);
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) answer[i] = players[i].num + 1;

        return answer;
    }
}

class Player implements Comparable<Player> {
    int num, weight;
    double win_rate = 0;
    int win_heavy = 0;

    public Player(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }

    @Override
    public int compareTo(Player o) {
        if (this.win_rate == o.win_rate) {
            if (this.win_heavy == o.win_heavy) {
                if (this.weight == o.weight) {
                    return this.num - o.num;
                }
                return o.weight - this.weight;
            }
            return o.win_heavy - this.win_heavy;
        }
        return Double.compare(o.win_rate, this.win_rate);
    }
}

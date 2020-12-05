package BFS.P14226;

import java.util.*;

public class Main {

    static int S;
    static Queue<State> q = new LinkedList<>();
    static boolean[][] visited = new boolean[10001][10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();

        int ans = 0;
        q.offer(new State(1, 0, 0));
        while (!q.isEmpty()) {
            State s = q.poll();
            visited[s.screen][s.clip] = true;

            if (s.screen == S) {
                ans = s.time;
                break;
            } else if (!visited[s.screen][s.screen]) {
                q.add(new State(s.screen, s.screen, s.time + 1));
            }

            if (s.screen + s.clip == S) {
                ans = s.time + 1;
                break;
            } else if (s.clip != 0 && !visited[s.screen + s.clip][s.clip]) {
                q.add(new State(s.screen + s.clip, s.clip, s.time + 1));
            }

            if (s.screen - 1 == S) {
                ans = s.time + 1;
                break;
            } else if (s.screen >= 1 && !visited[s.screen - 1][s.clip]) {
                q.add(new State(s.screen - 1, s.clip, s.time + 1));
            }
        }

        System.out.println(ans);
    }
}

class State {
    int screen;
    int clip;
    int time;

    public State(int screen, int clip, int time) {
        this.screen = screen;
        this.clip = clip;
        this.time = time;
    }

    @Override
    public String toString() {
        return "State{" +
                "screen=" + screen +
                ", clip=" + clip +
                ", time=" + time +
                '}';
    }
}
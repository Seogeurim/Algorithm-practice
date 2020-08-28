package Simulation.P1713;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, V;
    static Vote[] candi;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P1713/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());

        candi = new Vote[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++) {
            int num = Integer.parseInt(st.nextToken());
            int exist = find(num);
            if (exist >= 0) {
                candi[exist].count ++;
            } else {
                if (cnt < N) {
                    candi[cnt] = new Vote(num, i);
                    cnt ++;
                } else {
                    candi[getMin()].init(num, i);
                }
            }
        }

        int[] ans = new int[N];
        for (int i = 0; i < N && candi[i] != null; i++) {
            ans[i] = candi[i].num;
        }
        Arrays.sort(ans);
        for (int i = 0; i < N; i++) {
            if (ans[i] == 0) continue;
            System.out.print(ans[i] + " ");
        }
        System.out.println("");
    }

    static int find(int num) {
        for (int i = 0; i < N && candi[i] != null; i++) {
            if (candi[i].num  == num) return i;
        }
        return -1;
    }

    static int getMin() {
        int min = 1001;
        int min_idx = -1;
        for (int i = 0; i < N; i++) {
            int count = candi[i].count;
            if (count < min) {
                min = count;
                min_idx = i;
            } else if (count == min && candi[i].old < candi[min_idx].old) {
                min = count;
                min_idx = i;
            }
        }

        return min_idx;
    }
}

class Vote {
    int num;
    int count;
    int old;

    public Vote(int num, int old) {
        this.num = num;
        this.count = 1;
        this.old = old;
    }

    void init(int num, int old) {
        this.num = num;
        this.count = 1;
        this.old = old;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "num=" + num +
                ", count=" + count +
                ", old=" + old +
                '}';
    }
}
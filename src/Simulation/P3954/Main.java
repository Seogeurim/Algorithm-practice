package Simulation.P3954;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    final static int MOD = 256;
    final static int END = 50000000;

    static int T, M, C, I;
    static String program, input;
    static int[] brackets;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P3954/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            I = Integer.parseInt(st.nextToken());
            program = br.readLine();
            input = br.readLine();
            play();
        }
    }

    static void makeBrackets() {
        brackets = new int[C];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < C; i++) {
            char c = program.charAt(i);
            if (c == '[') s.push(i);
            else if (c == ']') {
                int prev = s.pop();
                brackets[i] = prev;
                brackets[prev] = i;
            }
        }
    }

    static void play() {
        makeBrackets();
        int m = 0, i = 0, l = 0, c = 0, cnt = 0;
        int[] arr = new int[M];

        while (cnt++ <= END*2) {
            if (c == C) { System.out.println("Terminates"); return; }
            char p = program.charAt(c);
            switch (p) {
                case '-': arr[m] = (arr[m]-1) % MOD; break;
                case '+': arr[m] = (arr[m]+1) % MOD; break;
                case '<': if (--m < 0) m += M; break;
                case '>': if (++m == M) m = 0; break;
                case '[':
                    if (arr[m] == 0) c = brackets[c];
                    break;
                case ']':
                    if (arr[m] != 0) {
                        if (cnt > END) l = Math.max(l, c);
                        c = brackets[c];
                    }
                    break;
                case '.': break;
                case ',':
                    if (i == I) arr[m] = 255;
                    else arr[m] = input.charAt(i++);
                    break;
            }
            c++;
        }

        System.out.println("Loops " + brackets[l] + " " + l);
    }
}

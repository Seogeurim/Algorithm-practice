package Queue.P3190;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K, L;
    static int[][] board;
    static Map<Integer, Character> rotate = new HashMap<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Queue/P3190/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            board[row][col] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            rotate.put(time, dir);
        }

        Deque<Position> snake = new ArrayDeque<>();
        snake.add(new Position(0, 0, 'R'));
        board[0][0] = 2;
        int time = 0;
        while (true) {
            Position head = snake.peekLast();
            assert head != null;

            if (rotate.containsKey(time)) head.rotate(rotate.get(time));
            time ++;

            Position to = head.move();
            if (!isValidPath(to.i, to.j) || board[to.i][to.j] == 2)
                break;
            if (board[to.i][to.j] == 0) {
                Position tail = snake.poll();
                assert tail != null;
                board[tail.i][tail.j] = 0;
            }
            snake.addLast(to);
            board[to.i][to.j] = 2;
        }

        System.out.println(time);
    }

    static boolean isValidPath(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}

class Position {
    int i;
    int j;
    char d;

    public Position(int i, int j, char d) {
        this.i = i;
        this.j = j;
        this.d = d;
    }

    Position move() {
        switch (this.d) {
            case 'L': return new Position(this.i, this.j - 1, this.d);
            case 'R': return new Position(this.i, this.j + 1, this.d);
            case 'U': return new Position(this.i - 1, this.j, this.d);
            case 'D': return new Position(this.i + 1, this.j, this.d);
            default : return new Position(this.i, this.j, this.d);
        }
    }

    void rotate(char dir) {
        switch (this.d) {
            case 'L':
                if (dir == 'L') this.d = 'D';
                else if (dir == 'D') this.d = 'U';
                break;
            case 'R':
                if (dir == 'L') this.d = 'U';
                else if (dir == 'D') this.d = 'D';
                break;
            case 'U':
                if (dir == 'L') this.d = 'L';
                else if (dir == 'D') this.d = 'R';
                break;
            case 'D':
                if (dir == 'L') this.d = 'R';
                else if (dir == 'D') this.d = 'L';
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Position{" + "i=" + i + ", j=" + j + ", d=" + d + '}';
    }
}
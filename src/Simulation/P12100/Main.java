package Simulation.P12100;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Simulation/P12100/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int count) {
        if (count == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }

        int[][] temp = new int[N][N];
        for (int c = 0; c < N; c++) {
            System.arraycopy(board[c], 0, temp[c], 0, N);
        }

        for (int i = 0; i < 4; i++) {
            play(i);
            dfs(count + 1);
            for (int c = 0; c < N; c++) {
                System.arraycopy(temp[c], 0, board[c], 0, N);
            }
        }
    }

    static void play(int cmd) {
        if (cmd == 0) moveUp();
        else if (cmd == 1) moveDown();
        else if (cmd == 2) moveLeft();
        else moveRight();
    }

    static void moveUp() {
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N-1; i++) {
                int k = i+1;
                while (k < N-1 && board[k][j] == 0) k++;
                if (board[i][j] == 0) {
                    board[i][j] = board[k][j];
                    board[k][j] = 0;
                    k = i+1;
                    while (k < N-1 && board[k][j] == 0) k++;
                }
                if (board[i][j] == board[k][j]) {
                    board[i][j] *= 2;
                    board[k][j] = 0;
                }
            }
        }
    }

    static void moveDown() {
        for (int j = 0; j < N; j++) {
            for (int i = N-1; i > 0; i--) {
                int k = i-1;
                while (k > 0 && board[k][j] == 0) k--;
                if (board[i][j] == 0) {
                    board[i][j] = board[k][j];
                    board[k][j] = 0;
                    k = i-1;
                    while (k > 0 && board[k][j] == 0) k--;
                }
                if (board[i][j] == board[k][j]) {
                    board[i][j] *= 2;
                    board[k][j] = 0;
                }
            }
        }
    }

    static void moveLeft() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                int k = j+1;
                while (k < N-1 && board[i][k] == 0) k++;
                if (board[i][j] == 0) {
                    board[i][j] = board[i][k];
                    board[i][k] = 0;
                    k = j+1;
                    while (k < N-1 && board[i][k] == 0) k++;
                }
                if (board[i][j] == board[i][k]) {
                    board[i][j] *= 2;
                    board[i][k] = 0;
                }
            }
        }
    }

    static void moveRight() {
        for (int i = 0; i < N; i++) {
            for (int j = N-1; j > 0; j--) {
                int k = j-1;
                while (k > 0 && board[i][k] == 0) k--;
                if (board[i][j] == 0) {
                    board[i][j] = board[i][k];
                    board[i][k] = 0;
                    k = j-1;
                    while (k > 0 && board[i][k] == 0) k--;
                }
                if (board[i][j] == board[i][k]) {
                    board[i][j] *= 2;
                    board[i][k] = 0;
                }
            }
        }
    }
}

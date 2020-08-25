package _2020_KAKAO_BLIND_RECRUITMENT.P5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 5;
        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};

        System.out.println(Arrays.deepToString(sol.solution(n, build_frame)));

        int m = 5;
        int[][] build_frame2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},
        {2,0,0,0},{1,1,1,0},{2,2,0,1}, {0,0,0,0}};

        System.out.println(Arrays.deepToString(sol.solution(m, build_frame2)));
    }
}

class Solution {

    static boolean[][] col;
    static boolean[][] row;
    static int max_idx;
    static int count;

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;

        col = new boolean[n+1][n+1];
        row = new boolean[n+1][n+1];
        max_idx = n;
        count = 0;

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int a = build[2];
            int b = build[3];
            if (b == 1) {
                if (a == 0) addColumn(x, y);
                else addRow(x, y);
            } else {
                remove(x, y, a);
            }
        }

        answer = new int[count][3];
        int idx = 0;

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (col[i][j]) answer[idx++] = new int[]{i, j, 0};
                if (row[i][j]) answer[idx++] = new int[]{i, j, 1};
            }
        }

        return answer;
    }

    static boolean canGo(int idx) {
        return idx >= 0 && idx <= max_idx;
    }

    static boolean isValidCol(int x, int y){
        return y == 0 ||
                (canGo(x-1) && row[x-1][y]) ||
                row[x][y] ||
                (canGo(y-1) && col[x][y-1]);
    }

    static boolean isValidRow(int x, int y){
        return (canGo(y-1) && col[x][y-1]) ||
                (canGo(x+1) && canGo(y-1) && col[x+1][y-1]) ||
                (canGo(x-1) && canGo(x+1) && row[x-1][y] && row[x+1][y]);
    }

    static void addColumn(int x, int y){
        if (isValidCol(x, y)) {
            col[x][y] = true;
            count ++;
        }
    }

    static void addRow(int x, int y){
        if (isValidRow(x, y)) {
            row[x][y] = true;
            count ++;
        }
    }

    static void remove(int x, int y, int type){
        if (type == 0) col[x][y] = false;
        else row[x][y] = false;
        count --;

        for (int i = 0; i < max_idx+1; i++) {
            for (int j = 0; j < max_idx+1; j++) {
                if (col[i][j] && !isValidCol(i, j)) {
                    if (type == 0) col[x][y] = true;
                    else row[x][y] = true;
                    count ++;
                    return;
                }
                if (row[i][j] && !isValidRow(i, j)) {
                    if (type == 0) col[x][y] = true;
                    else row[x][y] = true;
                    count ++;
                    return;
                }
            }
        }
    }
}
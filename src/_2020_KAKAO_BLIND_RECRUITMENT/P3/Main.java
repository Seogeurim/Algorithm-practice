package _2020_KAKAO_BLIND_RECRUITMENT.P3;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};

        System.out.println(sol.solution(key, lock));
    }
}

class Solution {
    public boolean solution(int[][] key, int[][] lock) {

        int N = lock.length;
        int M = key.length;

        int minI = N, minJ = N, maxI = 0, maxJ = 0;
        boolean hasHome = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0) {
                    minI = Math.min(i, minI);
                    minJ = Math.min(j, minJ);
                    maxI = Math.max(i, maxI);
                    maxJ = Math.max(j, maxJ);
                    hasHome = true;
                }
            }
        }

        if (!hasHome) return true;

        int find_i = maxI - minI + 1;
        int find_j = maxJ - minJ + 1;
        int[][] find = new int[find_i][find_j];
        for (int i = 0; i < find_i; i++) {
            for (int j = 0; j < find_j; j++) {
                if (lock[minI + i][minJ + j] == 1) find[i][j] = 0;
                else find[i][j] = 1;
            }
        }

        for (int t = 0; t < 4; t++) {
            for (int i = 0; i < M - find_i + 1; i++) {
                for (int j = 0; j < M - find_j + 1; j++) {
                    if (check(i, j, key, find_i, find_j, find)) {
                        return true;
                    }
                }
            }
            key = rotateArr(M, key);
        }

        return false;
    }

    static boolean check(int key_i, int key_j, int[][] key, int find_i, int find_j, int[][] find){
        for (int i = 0; i < find_i; i++) {
            for (int j = 0; j < find_j; j++) {
                if (find[i][j] != key[key_i + i][key_j + j])
                    return false;
            }
        }
        return true;
    }

    static int[][] rotateArr(int n, int[][] arr) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = arr[n-j-1][i];
            }
        }

        return result;
    }
}
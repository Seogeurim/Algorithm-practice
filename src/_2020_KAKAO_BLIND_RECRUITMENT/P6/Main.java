package _2020_KAKAO_BLIND_RECRUITMENT.P6;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}));
        System.out.println(sol.solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7}));
        System.out.println(sol.solution(50, new int[]{1}, new int[]{6})); // 1
        System.out.println(sol.solution(200, new int[]{0, 10, 50, 80, 120, 160}, new int[]{1, 10, 5, 40, 30})); //3
    }
}

class Solution {

    static int[] board;
    static int weakLen;

    static boolean[] visited;
    static int[] case_;

    static int answer;

    public int solution(int n, int[] weak, int[] dist) {

        weakLen = weak.length;
        board = new int[2 * weakLen - 1];
        makeBoard(weak, n);

        answer = -1;

        visited = new boolean[dist.length];
        for (int i = 1; i <= dist.length; i++) {
            case_ = new int[i];
            if (answer > 0) break;
            getCases(dist, i, 0);
        }

        return answer;
    }

    static void makeBoard(int[] weak, int n) {
        System.arraycopy(weak, 0, board, 0, weakLen);
        for (int i = weakLen; i < board.length; i++) {
            board[i] = n + weak[i - weakLen];
        }
    }

    static void getCases(int[] arr, int count, int current) {
        if (answer > 0) return;
        if (current == count) {
            check(case_);
            return;
        }
        for (int i = arr.length - 1; i >=0 ; i--) {
            if (!visited[i]) {
                visited[i] = true;
                case_[current] = arr[i];
                getCases(arr, count, current + 1);
                visited[i] = false;
            }
        }
    }

    static void check(int[] arr) {
        for (int i = 0; i < weakLen; i++) {
            boolean[] checked = new boolean[weakLen];

            int w_idx = i;
            for (int a : arr) {
                checked[w_idx - i] = true;
                int move = board[w_idx] + a;

                for (int j = w_idx + 1; j < i + weakLen; j++) {
                    w_idx = j;
                    if (board[j] <= move) checked[w_idx - i] = true;
                    else break;
                }
            }

            if (pass(checked)) {
                answer = arr.length;
                return;
            }
        }
    }

    static boolean pass(boolean[] arr) {
        for (boolean a : arr) {
            if (!a) return false;
        }
        return true;
    }
}

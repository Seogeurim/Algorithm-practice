package _2020_카카오_인턴십.P1;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(sol.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(sol.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
        System.out.println(sol.solution(new int[]{2, 5, 8, 0}, "right"));
    }
}

class Solution {

    static int[] dx = {-3, 3, -1, 1};

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int left = 10, right = 12;
        for (int n : numbers) {
            boolean goLeft;

            if (n == 1 || n == 4 || n == 7) goLeft = true;
            else if (n == 3 || n == 6 || n == 9) goLeft = false;
            else {
                int left_count = move((left == 0) ? 11 : left, (n == 0) ? 11 : n);
                int right_count = move((right == 0) ? 11 : right, (n == 0) ? 11 : n);
                if (left_count < right_count) goLeft = true;
                else if (left_count > right_count) goLeft = false;
                else goLeft = hand.equals("left");
            }

            if (goLeft) {
                left = n;
                answer.append('L');
            } else {
                right = n;
                answer.append('R');
            }
        }

        return answer.toString();
    }

    private static int move(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[13];

        q.offer(start);
        int count = 0;
        while (!q.isEmpty()) {
            int curSize = q.size();
            while (curSize-- > 0) {
                int cur = q.poll();
                visited[cur] = true;

                if (cur == target) return count;

                for (int i = 0; i < 4; i++) {
                    if (cur % 3 == 0 && i == 3) continue;
                    if ((cur - 1) % 3 == 0 && i == 2) continue;

                    int to = cur + dx[i];
                    if (0 < to && to < 13 && !visited[to]) {
                        q.offer(to);
                    }
                }
            }
            count ++;
        }

        return count;
    }
}
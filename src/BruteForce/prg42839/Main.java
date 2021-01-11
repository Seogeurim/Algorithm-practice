package BruteForce.prg42839;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("17")); // 3
        System.out.println(sol.solution("011")); // 2
    }
}

class Solution {

    String numbers;
    HashSet<Integer> set;
    boolean[] visited;

    public int solution(String numbers) {
        this.numbers = numbers;

        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        makeNum(0, "");

        return set.size();
    }

    boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        int end = (int) Math.sqrt(n);
        for (int i = 2; i <= end; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    void makeNum(int count, String s) {
        if (count > 0 && count <= numbers.length()) {
            int num = Integer.parseInt(s);
            if (isPrime(num)) set.add(num);
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNum(count + 1, s + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
}

package Graph.prg43162;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(sol.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}

// 1 1 0
// 1 1 0
// 0 0 1

// 1 1 0
// 1 1 1
// 0 1 1

class Solution {

    static int[] root;

    public int solution(int n, int[][] computers) {
        root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (computers[i][j] == 1) merge(i, j);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(find(i));

        return set.size();
    }

    static int find(int n) {
        if (root[n] == n) return n;
        return root[n] = find(root[n]);
    }

    static void merge(int a, int b) {
        root[find(b)] = find(a);
    }
}

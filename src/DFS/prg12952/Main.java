package DFS.prg12952;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4));
    }
}

class Solution {

    int[] col;
    int ans;

    public int solution(int n) {

        col = new int[n];
        ans = 0;
        dfs(0, n);

        return ans;
    }

    private void dfs(int cnt, int n) {
        if (cnt == n) {
            ans ++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(cnt, i, n)) {
                col[cnt] = i;
                dfs(cnt+1, n);
            }
        }
    }

    private boolean check(int i, int j, int n) {
        for (int k = 0; k < i; k++) {
            if (col[k] == j) return false;
            if (Math.abs(j - col[k]) == i - k) return false;
        }
        return true;
    }
}

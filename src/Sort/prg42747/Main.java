package Sort.prg42747;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(sol.solution(new int[]{0, 1, 3, 3, 5, 6, 7, 8}));
        System.out.println(sol.solution(new int[]{0}));
    }

}

class Solution {

    int[] arr;
    int n;

    public int solution(int[] citations) {
        arr = citations;
        n = citations.length;
        Arrays.sort(arr);

        int h = citations[n-1];
        for (; h >= 0; h--) {
            int ub = upper_bound(h);
            int more = n - ub;
            int less = (arr[ub] == h) ? ub + 1 : ub;
            if (more >= h && less <= h) return h;
        }
        return 0;
    }

    public int upper_bound(int k) {
        int left = 0, right = n-1, mid = (left+right)/2;
        while (left < right) {
            if (arr[mid] >= k) right = mid;
            else left = mid + 1;
            mid = (left+right)/2;
        }
        return right;
    }
}

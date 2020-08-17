package Permutation.P5568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N, K;
    static int[] nums;
    static int[] cases = new int[4];
    static boolean[] visited = new boolean[10];
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Permutation/P5568/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        dfs(0);

        Collections.sort(ans);
        int count = 1;
        for (int i = 1; i < ans.size(); i++) {
            if (!ans.get(i).equals(ans.get(i - 1))){
                count ++;
            }
        }

        System.out.println(count);

        br.close();
    }

    static void dfs(int count){
        if (count == K) {
            ans.add(arrToNum(cases, K));
            return;
        }
        int selected = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && nums[i] != selected) {
                visited[i] = true;
                cases[count] = nums[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }

    static int arrToNum(int[] arr, int size){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(String.valueOf(sb));
    }
}

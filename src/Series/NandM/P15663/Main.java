package Series.NandM.P15663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] nums;
    static boolean[] visited = new boolean[8];
    static int[] result = new int[8];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/Series/NandM/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(0);
    }

    static void dfs(int count){
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println("");
            return;
        }
        int old = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && nums[i] != old) {
                visited[i] = true;
                result[count] = nums[i];
                old = nums[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }
}

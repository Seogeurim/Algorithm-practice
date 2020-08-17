package Series.NandM.P15650;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] nums = new int[8];
    static boolean[] visited = new boolean[8];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/Series/NandM/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0, 0);
    }

    static void dfs(int count, int last){
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println("");
            return;
        }
        for (int i = last; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums[count] = i + 1;
                dfs(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

package Series.NandM.P15664;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] nums;
    static int[] ans = new int[8];
    static boolean[] visited = new boolean[8];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/Series/NandM/input.txt"));
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
        dfs(0, 0);

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int count, int last) throws IOException {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                bw.write(ans[i] + " ");
            }
            bw.newLine();
            return;
        }
        int selected = 0;
        for (int i = last; i < N; i++) {
            if (!visited[i] && nums[i] != selected) {
                visited[i] = true;
                ans[count] = nums[i];
                selected = nums[i];
                dfs(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

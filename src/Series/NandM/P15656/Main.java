package Series.NandM.P15656;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] nums;
    static int[] ans = new int[7];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
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

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int count) throws IOException {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                bw.write(ans[i] + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < N; i++) {
            ans[count] = nums[i];
            dfs(count + 1);
        }
    }
}

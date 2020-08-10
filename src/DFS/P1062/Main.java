package DFS.P1062;

import java.util.Scanner;

public class Main {

    static int N, K;
    static String[] words;
    static boolean[] visited;
    static int selected = 5;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/DFS/P1062/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.next());
        K = Integer.parseInt(sc.next());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next().replaceAll("[antic]", "");
        }

        if (K < 5) {
            System.out.println(ans);
        } else {
            visited = new boolean[26];
            visited[0] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;

            ans = countWords();

            for (int i = 0; i < 26; i++) {
                if (!visited[i])
                    dfs(i);
            }

            System.out.println(ans);
        }
    }

    static void dfs(int index){
        visited[index] = true;
        selected++;

        if (selected == K) {
            ans = Math.max(countWords(), ans);
        } else {
            for (int i = index + 1; i < 26; i++) {
                if (!visited[i])
                    dfs(i);
            }
        }

        visited[index] = false;
        selected--;
    }

    static int countWords(){
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = words[i];
            boolean isPossible = true;
            for (int j = 0; j < word.length(); j++) {
                if(!visited[word.charAt(j) - 'a']) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible)
                count++;
        }

        return count;
    }
}

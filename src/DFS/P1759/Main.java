package DFS.P1759;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int L, C;
    static String[] words;
    static boolean[] visited;
    static int selected = 0;

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("src/DFS/P1759/input.txt"));
        Scanner sc = new Scanner(System.in);

        L = Integer.parseInt(sc.next());
        C = Integer.parseInt(sc.next());

        words = new String[C];
        visited = new boolean[C];

        for (int i = 0; i < C; i++) {
            words[i] = sc.next();
        }
        Arrays.sort(words);

        for (int i = 0; i < C; i++) {
            if (!visited[i])
                dfs(i);
        }
    }

    static void dfs(int index){
        visited[index] = true;
        selected++;
        if (selected == L) {
            String target = selectWords();
            if(isMatch(target))
                System.out.println(target);
        } else {
            for (int i = index + 1; i < C; i++) {
                if (!visited[i])
                    dfs(i);
            }
        }
        visited[index] = false;
        selected--;
    }

    static String selectWords(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < C; i++) {
            if(visited[i]){
                result.append(words[i]);
            }
        }
        return result.toString();
    }

    static boolean isMatch(String target){
        int vowelCnt = 0, consoCnt = 0;
        for (int i = 0; i < target.length(); i++) {
            if (isVowel(target.charAt(i)))
                vowelCnt++;
            else
                consoCnt++;
        }
        return vowelCnt >= 1 && consoCnt >= 2;
    }

    static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

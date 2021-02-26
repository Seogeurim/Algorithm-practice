package String.P17413;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/String/P17413/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine() + " ";
        StringBuilder w = new StringBuilder(), sb = new StringBuilder();

        boolean stop = false;
        for (int i = 0, size = s.length(); i < size; i++) {
            char c = s.charAt(i);
            if (c == '<') stop = true;

            if (!stop && c != ' ') w.append(c);
            else if (w.length() > 0) { sb.append(w.reverse()).append(c); w.setLength(0); }
            else sb.append(c);

            if (c == '>') stop = false;
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }
}

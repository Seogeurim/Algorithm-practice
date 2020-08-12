package Stack.P10828;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static String command;
    static List<Integer> stack;

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("src/Stack/P10828/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stack = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            command = br.readLine();
            if (command.contains("push")) {
                push(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                pop();
            } else if (command.equals("size")) {
                size();
            } else if (command.equals("empty")) {
                empty();
            } else if (command.equals("top")) {
                top();
            }
        }

    }

    static void push(int value){
        stack.add(value);
    }

    static void pop(){
        if (!stack.isEmpty())
            System.out.println(stack.remove(stack.size()-1));
        else System.out.println(-1);
    }

    static void size(){
        System.out.println(stack.size());
    }

    static void empty(){
        if (stack.isEmpty())
            System.out.println(1);
        else System.out.println(0);
    }

    static void top(){
        if (!stack.isEmpty())
            System.out.println(stack.get(stack.size()-1));
        else System.out.println(-1);
    }
}

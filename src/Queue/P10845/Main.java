package Queue.P10845;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, result;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/Queue/P10845/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Queue queue = new Queue();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if (command.contains("push")) {
                queue.push(Integer.parseInt(command.split(" ")[1]));
            } else {
                if (command.equals("pop")) result = queue.pop();
                else if (command.equals("size")) result = queue.size();
                else if (command.equals("empty")) result = queue.empty();
                else if (command.equals("front")) result = queue.front();
                else if (command.equals("back")) result = queue.back();
                System.out.println(result);
            }
        }
    }
}

class Queue {
    List<Integer> queue;

    public Queue() {
        this.queue = new ArrayList<>();
    }

    public void push(int value){
        queue.add(value);
    }

    public int pop(){
        if (queue.isEmpty())
            return -1;

        int top = queue.get(0);
        for (int i = 1; i < queue.size(); i++) {
            queue.set(i-1, queue.get(i));
        }
        queue.remove(queue.size() - 1);
        return top;
    }

    public int size(){
        return queue.size();
    }

    public int empty(){
        if (queue.isEmpty()) return 1;
        return 0;
    }

    public int front(){
        if (queue.isEmpty())
            return -1;
        return queue.get(0);
    }

    public int back(){
        if (queue.isEmpty())
            return -1;
        return queue.get(queue.size() - 1);
    }
}
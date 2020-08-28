package Stack.P3425;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    static Program pro;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Stack/P3425/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cmd = br.readLine();
        while (!cmd.equals("QUIT")) {
            ArrayList<String> commands = new ArrayList<>();

            while(!cmd.equals("END")) {
                commands.add(cmd);
                cmd = br.readLine();
            }

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                pro = new Program(num, commands);
            }
            System.out.println("");

            br.readLine();
            cmd = br.readLine();
        }
    }
}

class Program {
    Stack<Integer> stack = new Stack<>();
    final int MAX = 1000000000;
    boolean error = false;

    public Program(int num, ArrayList<String> commands) {
        this.stack.push(num);
        for (String cmd : commands) {
            if (this.error) break;

            if (cmd.matches(".*[0-9]")) {
                this.num(Integer.parseInt(cmd.substring(4)));
            } else {
                switch (cmd) {
                    case "POP":
                        this.pop();
                        break;
                    case "INV":
                        this.inv();
                        break;
                    case "DUP":
                        this.dup();
                        break;
                    case "SWP":
                        this.swp();
                        break;
                    default:
                        this.oper(cmd);
                        break;
                }
            }
        }

        if (this.error || stack.size() != 1) System.out.println("ERROR");
        else System.out.println(stack.pop());
    }

    void num(int x) {
        this.stack.push(x);
    }

    void pop() {
        if (this.validSize(1)) this.stack.pop();
    }

    void inv() {
        if (!this.validSize(1)) return;
        int target = this.stack.pop();
        this.stack.push(target * (-1));
    }

    void dup() {
        if (!this.validSize(1)) return;
        int target = this.stack.peek();
        this.stack.push(target);
    }

    void swp() {
        if (!this.validSize(2)) return;
        int first = this.stack.pop();
        int second = this.stack.pop();
        this.stack.push(first);
        this.stack.push(second);
    }

    void oper(String o) {
        if (!this.validSize(2)) return;
        int first = this.stack.pop();
        int second = this.stack.pop();
        switch (o) {
            case "ADD":
                this.add(second, first);
                break;
            case "SUB":
                this.sub(second, first);
                break;
            case "MUL":
                this.mul(second, first);
                break;
            case "DIV":
                this.div(second, first);
                break;
            case "MOD":
                this.mod(second, first);
                break;
            default:
                break;
        }
    }

    void add(int x, int y) {
        long result = x + y;
        if (this.validNum(result)) this.stack.push((int) result);
    }

    void sub(int x, int y) {
        long result = x - y;
        if (this.validNum(result)) this.stack.push((int) result);
    }

    void mul(int x, int y) {
        if (x != 0 && y!= 0) {
            int x_len = (int) Math.log10(x) + 1;
            int y_len = (int) Math.log10(y) + 1;
            if (x_len + y_len > 10) {
                this.error = true;
                return;
            }
        }
        long result = x * y;
        if (this.validNum(result)) this.stack.push((int) result);
    }

    void div(int x, int y) {
        if (y == 0) {
            this.error = true;
            return;
        }
        long result = Math.abs(x) / Math.abs(y);
        if ((x < 0 && y > 0) || (x > 0 && y < 0)) result *= -1;
        if (this.validNum(result)) this.stack.push((int) result);
    }

    void mod(int x, int y) {
        if (y == 0) {
            this.error = true;
            return;
        }
        long result = Math.abs(x) % Math.abs(y);
        if (x < 0) result *= -1;
        if (this.validNum(result)) this.stack.push((int) result);
    }

    boolean validSize(int targetSize) {
        if (this.stack.size() < targetSize) {
            this.error = true;
            return false;
        }
        return true;
    }

    boolean validNum(long target) {
        if (Math.abs(target) > this.MAX) {
            this.error = true;
            return false;
        }
        return true;
    }
}

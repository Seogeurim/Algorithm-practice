package Stack.P2504;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String input;
    static Stack<Element> stack;
    static boolean isValid = true;

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("src/Stack/P2504/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if (target == '(' || target == '[') {
                stack.push(new Element(target));
            } else if (target == ')') {
                int value = 0;
                while (!stack.empty() && stack.peek().isValue) {
                    value += stack.pop().value;
                }
                if (value == 0) value = 1;
                if (!stack.empty() && stack.peek().command == '('){
                    stack.pop();
                    stack.push(new Element(2 * value));
                } else {
                    isValid = false;
                    break;
                }
            } else if (target == ']') {
                int value = 0;
                while (!stack.empty() && stack.peek().isValue) {
                    value += stack.pop().value;
                }
                if (value == 0) value = 1;
                if (!stack.empty() && stack.peek().command == '['){
                    stack.pop();
                    stack.push(new Element(3 * value));
                } else {
                    isValid = false;
                    break;
                }
            } else {
                isValid = false;
                break;
            }
//            System.out.println(stack.toString());
        }

        int result = 0;
        if (isValid) {
            while (!stack.empty()) {
                Element target = stack.pop();
                if (!target.isValue) {
                    result = 0;
                    break;
                }
                result += target.value;
            }
        }
        System.out.println(result);
    }
}

class Element {
    boolean isValue;
    int value;
    char command;

    public Element(int value) {
        this.isValue = true;
        this.value = value;
    }

    public Element(char command) {
        this.isValue = false;
        this.command = command;
    }

    @Override
    public String toString() {
        if (isValue) return "" + value;
        else return "" + command;
    }
}
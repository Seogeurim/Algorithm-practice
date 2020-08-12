package Heap.P11279;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("src/Heap/P11279/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        MaxHeap heap = new MaxHeap();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 0) heap.insert(x);
            else System.out.println(heap.remove());
//            System.out.println(heap);
        }

    }
}

class MaxHeap{
    List<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        heap.add(0);
    }

    public void insert(int value){
        heap.add(value);
        int current = heap.size() - 1;
        int parent = current / 2;

        while (parent != 0) {
            if (heap.get(current) > heap.get(parent)) {
                int temp = heap.get(current);
                heap.set(current, heap.get(parent));
                heap.set(parent, temp);
                current = parent;
                parent = current / 2;
            } else {
                break;
            }
        }
    }

    public int remove(){
        if (heap.size() == 1)
            return 0;

        int top = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int current = 1;
        while (true) {
            int left = current * 2;
            if (left >= heap.size())
                break;

            int maxIdx = left;
            int right = current * 2 + 1;
            if (right < heap.size() && heap.get(maxIdx) < heap.get(right)) {
                maxIdx = right;
            }

            if (heap.get(current) < heap.get(maxIdx)) {
                int temp = heap.get(current);
                heap.set(current, heap.get(maxIdx));
                heap.set(maxIdx, temp);
                current = maxIdx;
            } else {
                break;
            }
        }

        return top;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "heap=" + heap +
                '}';
    }
}
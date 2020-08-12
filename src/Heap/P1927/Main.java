package Heap.P1927;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, x;
    static MinHeap heap;

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("src/Heap/P1927/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        heap = new MinHeap();
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if (x == 0) System.out.println(heap.remove());
            else heap.insert(x);
//            System.out.println(heap.toString());
        }
    }
}

class MinHeap {
    List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        heap.add(0);
    }

    public void insert(int value){
        heap.add(value);
        int current = heap.size() - 1;
        int parent = current / 2;

        while (parent != 0 && heap.get(parent) > heap.get(current)) {
            int temp = heap.get(parent);
            heap.set(parent, heap.get(current));
            heap.set(current, temp);

            current = parent;
            parent = current / 2;
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
            if (left >= heap.size()){
                break;
            }

            int targetIdx = left;
            int right = current * 2 + 1;
            if (right < heap.size() && heap.get(right) < heap.get(targetIdx)){
                targetIdx = right;
            }

            if (heap.get(targetIdx) < heap.get(current)){
                int temp = heap.get(current);
                heap.set(current, heap.get(targetIdx));
                heap.set(targetIdx, temp);
                current = targetIdx;
            } else {
                break;
            }
        }

        return top;
    }

    @Override
    public String toString() {
        return "MinHeap{" + heap + "}";
    }
}
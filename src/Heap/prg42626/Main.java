package Heap.prg42626;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 2, 3, 9, 10, 12}, 7)); // 2
    }
}

class Solution {

    int n;
    int[] heap;
    int cursor = 0;

    public int solution(int[] scoville, int K) {
        n = scoville.length;
        heap = new int[(int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1)];

        for (int i = 0; i < n; i++) {
            insert(scoville[i]);
        }

        int cnt = 0;
        while (cursor > 0 && heap[1] < K) {
            insert(removeRoot() + removeRoot() * 2);
            cnt ++;
        }

        if (cursor == 0) return -1;
        return cnt;
    }

    void insert(int value) {
        heap[++cursor] = value;
        int current = cursor;
        int parent = cursor / 2;

        while (parent != 0) {
            if (heap[parent] > heap[current]) {
                swap(current, parent);
                current = parent;
                parent = current / 2;
            } else {
                break;
            }
        }
    }

    int removeRoot() {
        int root = heap[1];
        heap[1] = heap[cursor];
        heap[cursor--] = 0;

        int current = 1;
        int child;

        while (true) {
            int left = current * 2;
            if (left > cursor) break;

            child = left;
            int right = current * 2 + 1;
            if (right <= cursor && heap[right] < heap[child]) {
                child = right;
            }

            if (heap[child] < heap[current]) {
                swap(current, child);
                current = child;
            } else {
                break;
            }
        }

        return root;
    }

    void swap(int idx1, int idx2) {
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }
}
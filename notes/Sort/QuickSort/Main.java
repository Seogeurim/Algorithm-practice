package Sort.QuickSort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int n = 100000000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }

        System.out.println("n : " + n);
        System.out.println("====== choice of pivot 2.1 ======");
        long start = System.currentTimeMillis();
        QuickSort qs1 = new QuickSort(arr, n);
        long end = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초");

        System.out.println("====== choice of pivot 2.2 ======");
        start = System.currentTimeMillis();
        QuickSort2 qs2 = new QuickSort2(arr, n);
        end = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초");

        System.out.println("====== choice of pivot 2.3 ======");
        start = System.currentTimeMillis();
        QuickSort3 qs3 = new QuickSort3(arr, n);
        end = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초");
    }
}

// The first element is the pivot
class QuickSort {

    int[] S;
    int comparison_count = 0;
    int exchange_count = 0;

    public QuickSort(int[] arr, int n) {
        this.S = new int[n];
        System.arraycopy(arr, 0, this.S, 0, n);

//        System.out.println(Arrays.toString(this.S));
        sort(0, n-1);
//        System.out.println(Arrays.toString(this.S));

        System.out.println("Comparison : " + this.comparison_count);
        System.out.println("Exchange : " + this.exchange_count);
    }

    void sort (int low, int high) {
        if (low < high) {
            int pivotPoint = partition(low, high);
            sort(low, pivotPoint-1);
            sort(pivotPoint+1, high);
        }
    }

    int partition(int low, int high) {
        int pivot = this.S[low];
        int j = low;
        for (int i = low+1; i <= high; i++) {
            if (this.S[i] < pivot) {
                this.comparison_count ++;
                j++;
                swap(i, j);
            }
        }
        swap(low, j);
        return j;
    }

    void swap(int a, int b) {
        this.exchange_count ++;
        int temp = this.S[a];
        this.S[a] = this.S[b];
        this.S[b] = temp;
    }
}

// A randomly chosen element between low and high is the pivot.
class QuickSort2 {

    int[] S;
    int comparison_count = 0;
    int exchange_count = 0;

    public QuickSort2(int[] arr, int n) {
        this.S = new int[n];
        System.arraycopy(arr, 0, this.S, 0, n);

//        System.out.println(Arrays.toString(this.S));
        sort2(0, n-1);
//        System.out.println(Arrays.toString(this.S));

        System.out.println("Comparison : " + this.comparison_count);
        System.out.println("Exchange : " + this.exchange_count);
    }

    void sort2 (int low, int high) {
        if (low < high) {
            int pivotPoint = partition2(low, high);
            sort2(low, pivotPoint-1);
            sort2(pivotPoint+1, high);
        }
    }

    int partition2(int low, int high) {
        Random random = new Random();
        int num = random.nextInt(2);

        int pivot;
        if (num == 0) {
            pivot = this.S[low];
        } else {
            pivot = this.S[high];
            swap(low, high);
        }

        int j = low;
        for (int i = low+1; i <= high; i++) {
            if (this.S[i] < pivot) {
                this.comparison_count ++;
                j++;
                swap(i, j);
            }
        }
        swap(low, j);
        return j;
    }

    void swap(int a, int b) {
        this.exchange_count ++;
        int temp = this.S[a];
        this.S[a] = this.S[b];
        this.S[b] = temp;
    }
}

// The pivot is chosen as the median number, as suggested by Robert Sedgewick,
// among the first, the last, and the mid elements between low and high.
class QuickSort3 {

    int[] S;
    int comparison_count = 0;
    int exchange_count = 0;

    public QuickSort3(int[] arr, int n) {
        this.S = new int[n];
        System.arraycopy(arr, 0, this.S, 0, n);

//        System.out.println(Arrays.toString(this.S));
        sort3(0, n-1);
//        System.out.println(Arrays.toString(this.S));

        System.out.println("Comparison : " + this.comparison_count);
        System.out.println("Exchange : " + this.exchange_count);
    }

    void sort3 (int low, int high) {
        if (low < high) {
            int pivotPoint = partition3(low, high);
            sort3(low, pivotPoint-1);
            sort3(pivotPoint+1, high);
        }
    }

    int partition3(int low, int high) {
        int mid = (low + high) / 2;
        int num = getMedian(low, mid, high);

        int pivot;
        if (num == low) {
            pivot = this.S[low];
        } else if (num == mid) {
            pivot = this.S[mid];
            swap(low, mid);
        } else {
            pivot = this.S[high];
            swap(low, high);
        }

        int j = low;
        for (int i = low+1; i <= high; i++) {
            if (this.S[i] < pivot) {
                this.comparison_count ++;
                j++;
                swap(i, j);
            }
        }
        swap(low, j);
        return j;
    }

    int getMedian(int a, int b, int c) {
        if (this.S[a] >= this.S[b]) {
            if (this.S[b] >= this.S[c]) return b;
            else if (this.S[a] <= this.S[c]) return a;
            else return c;
        } else if (this.S[a] > this.S[c]) {
            return a;
        } else if (this.S[b] > this.S[c]) {
            return c;
        } else {
            return b;
        }
    }

    void swap(int a, int b) {
        this.exchange_count ++;
        int temp = this.S[a];
        this.S[a] = this.S[b];
        this.S[b] = temp;
    }
}
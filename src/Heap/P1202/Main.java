package Heap.P1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static Jewel[] jewelArr;
    static int[] bag;

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("src/Heap/P1202/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewelArr = new Jewel[N];
        bag = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelArr[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelArr, Comparator.comparingInt(Jewel::getWeight));
        Arrays.sort(bag);

        PriorityQueue<Jewel> pq = new PriorityQueue<>(Comparator.comparingInt(Jewel::getValue).reversed());

        long sum = 0;
        int cursor = 0;
        for (int i = 0; i < K; i++) {
            while (cursor < N && (bag[i] >= jewelArr[cursor].weight)){
                pq.add(jewelArr[cursor++]);
            }
            if (!pq.isEmpty()){
                sum += pq.poll().value;
            }
        }

        System.out.println(sum);
    }
}

class Jewel {
    int weight;
    int value;

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Jewel{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}
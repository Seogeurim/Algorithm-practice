package TimeComplexity.P2143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long T;
    static int n, m;
    static int[] A, B;
    static long ans;

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("src/TimeComplexity/P2143/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> subA = subArr(A);
        List<Long> subB = subArr(B);

        Collections.sort(subA);
        Collections.sort(subB);

//        System.out.println(subA);
//        System.out.println(subB);

        for (int i = 0; i < subA.size(); i ++) {
            int upper = getUpperBound(subB, T - subA.get(i));
            int lower = getLowerBound(subB, T - subA.get(i));
//            System.out.println("upper : " + upper + " || lower : " + lower);
            ans += upper - lower;
        }
        System.out.println(ans);
    }

    static int getUpperBound(List<Long> arr, long target){
        int start = 0;
        int end = arr.size();
        int mid = 0;

        while (start < end) {
            mid = (start + end) / 2;
            if (arr.get(mid) <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    static int getLowerBound(List<Long> arr, long target){
        int start = 0;
        int end = arr.size();
        int mid = 0;

        while (start < end) {
            mid = (start + end) / 2;
            if (arr.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    static List<Long> subArr(int[] arr){
        List<Long> subArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            long sum = arr[i];
            subArr.add(sum);
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                subArr.add(sum);
            }
        }

        return subArr;
    }
}

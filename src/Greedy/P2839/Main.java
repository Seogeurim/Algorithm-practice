package Greedy.P2839;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        while (N > 0) {
            if (N%5==0) { ans += N/5; N = 0; }
            else { ans ++; N-= 3; }
        }
        if (N < 0) System.out.println(-1);
        else System.out.println(ans);
    }
}
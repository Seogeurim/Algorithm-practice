### [baekjoon-1932] 정수 삼각형

![image](https://user-images.githubusercontent.com/22045163/90809734-e2376900-e35c-11ea-9ea4-5d24978f43aa.png)

> 디버깅용 코드 

```java
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Node[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DP/P1932/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new Node[N * (N + 1) / 2 + 1];
        nums[0] = new Node(0, 0);

        int count = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (j == i) {
                    nums[count] = new Node(value, nums[count - i - 1].sum + value);
                } else if (j == 0) {
                    nums[count] = new Node(value, nums[count - i].sum + value);
                } else {
                    int parent_max = Math.max(nums[count - i - 1].sum, nums[count - i].sum);
                    nums[count] = new Node(value, parent_max + value);
                }
                count ++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}

class Node {
    int value;
    int sum;

    public Node(int value, int sum) {
        this.value = value;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", sum=" + sum +
                '}';
    }
}

```
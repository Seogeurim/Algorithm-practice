## [baekjoon-13544] 수열과 쿼리 3

![image](https://user-images.githubusercontent.com/22045163/105127378-243f2380-5b24-11eb-8e5a-c4d707816708.png)

### 시간 줄이기

[수열과 쿼리 1](../P13537) 문제와 거의 같은 문제이다. 
그 때 시간을 줄여도 시간이 2000ms 넘게 걸려서 고민이 됐는데, 
k보다 큰 수의 개수를 찾는 과정에서 이분 탐색의 Upper Bound 알고리즘을 쓰면 시간을 줄일 수 있다.

원래는 이렇게 풀었다. 
```java
static int findBigger(int[] arr, int k) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > k) return arr.length - i;
    }
    return 0;
}
```

Upper Bound 알고리즘을 쓰면 다음과 같다.
```java
static int upper_bound(int node, int k) {
    int left = 0, right = mst[node].length -1, mid;
    while (left < right) {
        mid = (left + right) / 2;
        if (mst[node][mid] > k) right = mid;
        else left = mid + 1;
    }
    if (mst[node][right] > k) return right;
    else return mst[node].length; // mst[node] 배열의 길이가 0인 경우 처리
}
```

![image](https://user-images.githubusercontent.com/22045163/105127557-7c762580-5b24-11eb-9e4a-7303bc9e2eec.png)

실행 시간이 거의 반 이상 줄어드는 것을 확인할 수 있다.

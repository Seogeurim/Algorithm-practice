## [baekjoon-12865] 평범한 배낭

![image](https://user-images.githubusercontent.com/22045163/113484575-060e8000-94e4-11eb-9d23-052a69f3151b.png)

### 점화식

#### 2차원 배열

```java
for (int i = 1; i <= N; i++) {
    for (int j = 1; j <= K; j++) {
        if (j < W[i]) dp[i][j] = dp[i-1][j];
        else dp[i][j] = Math.max(dp[i-1][j], V[i] + dp[i-1][j-W[i]]);
    }
}
```

#### 1차원 배열

```java
for (int i = 1; i <= N; i++) {
    for (int j = K; j >= W[i]; j--) {
        dp[j] = Math.max(dp[j], V[i] + dp[j-W[i]]);
    }
}
```

일차원 배열로 풀이하되, 이전 단계의 value 값을 사용하기 위해서는 뒤에서부터 탐색하면 된다.

![image](https://user-images.githubusercontent.com/22045163/113484581-0c046100-94e4-11eb-91f9-cc3468bd81c5.png)

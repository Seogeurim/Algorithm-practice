## [baekjoon-2098] 외판원 순회

![image](https://user-images.githubusercontent.com/22045163/112101265-b37ebb00-8be9-11eb-8302-789243835946.png)

### 외판원 순회 문제

외판원 순회 문제는 비트마스크 + DP 를 이용한 문제이다. 풀이 및 코드를 이해한 후, 외우는 것이 좋은 것 같다.

```java
int TSP(int mask, int now) {
    if (mask == (1<<N)-1) {
        if (W[now][0] > 0) return W[now][0];
        return INF;
    }

    if (dp[mask][now] != INF) return dp[mask][now];
    for (int i = 0; i < N; i++) {
        if ((mask & 1<<i) == 0 && W[now][i] > 0) {
            dp[mask][now] = Math.min(dp[mask][now], TSP(mask|1<<i, i) + W[now][i]);
        }
    }
    return dp[mask][now];
}
```

![image](https://user-images.githubusercontent.com/22045163/112101291-bc6f8c80-8be9-11eb-97ee-5add4fa8208f.png)

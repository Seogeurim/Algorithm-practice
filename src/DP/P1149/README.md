## [baekjoon-1149] RGB거리

![image](https://user-images.githubusercontent.com/22045163/112155641-d67c8f80-8c28-11eb-9964-3e9e5ca71092.png)

### 점화식

```java
dp[0][0] = cost[0][0];
dp[0][1] = cost[0][1];
dp[0][2] = cost[0][2];

dp[n][0] = cost[n][0] + Math.min(dp[n-1][1], dp[n-1][2]);
dp[n][1] = cost[n][1] + Math.min(dp[n-1][0], dp[n-1][2]);
dp[n][2] = cost[n][2] + Math.min(dp[n-1][0], dp[n-1][1]);
```

`n` 단계에서 빨강, 초록, 파랑 중 어떤 색을 색칠하느냐에 따른 정보를 모두 저장해놓아야 한다. 또한, 바로 전 단계인 `n-1` 단계와만 색깔이 다르면 된다. 그에 대한 최솟값을 구하면 된다.

![image](https://user-images.githubusercontent.com/22045163/112155709-e7c59c00-8c28-11eb-96d2-418f83bf81e7.png)

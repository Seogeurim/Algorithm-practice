## [baekjoon-2294] 동전 2

![image](https://user-images.githubusercontent.com/22045163/113482949-e4a99600-94db-11eb-880a-a3175ca47b51.png)

### 점화식

```java
dp[0] = 0 // 동전의 가치는 자연수임
for (int coin : coins) {
    dp[n] = Math.min(dp[n], 1 + dp[n-coin]);
}
```

동전이 1원, 5원이 있다고 할 때, 7원을 만드는 방법은 `5원 1개 + [2원을 만드는 방법의 최솟값]`, `1원 1개 + [6원을 만드는 방법의 최솟값]` 중 최솟값이다. 이를 점화식으로 표현하면 위와 같다.

![image](https://user-images.githubusercontent.com/22045163/113482952-eb380d80-94db-11eb-9987-c527e750daf9.png)

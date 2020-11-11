## [baekjoon-9095] 1, 2, 3 더하기

![image](https://user-images.githubusercontent.com/22045163/94254638-08ef4d80-ff62-11ea-9672-d64f3ef0f059.png)

### 점화식

```java
dp[1] = 1
dp[2] = 2
dp[3] = 4
dp[n] = dp[n-1] + dp[n-2] + dp[n-3];
```

정수 n을 1, 2, 3의 합으로 나타내는 방법은 dp[n-1]에 +1을 한 것, dp[n-2]에 +2를 한 것,
dp[n-3]에 +3을 한 것, 이 모든 경우의 수를 합친 것과 같다.
